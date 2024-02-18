package com.gdsc.plogger.auth;

import com.gdsc.plogger.auth.data.dto.req.LoginReq;
import com.gdsc.plogger.auth.data.dto.req.SignUpReq;
import com.gdsc.plogger.auth.data.dto.res.LoginRes;
import com.gdsc.plogger.config.jwt.JwtProvider;
import com.gdsc.plogger.member.MemberRepository;
import com.gdsc.plogger.member.data.Member;
import com.gdsc.plogger.member.data.dto.res.MemberGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    public ResponseEntity<LoginRes> login(LoginReq req) {
        // 1. email 조회후 없으면 생성 요청
        if (req == null)
            throw new IllegalArgumentException("잘못된 로그인 요청입니다.");

        if (!memberRepository.existsMemberByEmail(req.getEmail()))
            throw new IllegalArgumentException("유저가 존재하지 않습니다!");


        // 2. email 조회 후 있으면 로그인 성공
        Member member = memberRepository.findByEmail(req.getEmail()).orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다!"));

        String accessToken = jwtProvider.createToken(member.getId(), "access");
        String refreshToken = jwtProvider.createToken(member.getId(), "refresh");

        member.updateRefreshToken(refreshToken);
        memberRepository.save(member);

        LoginRes res = LoginRes.builder()
                .email(member.getEmail())
                .nickname(member.getNickname())
                .accessToken(accessToken)
                .build();

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

//    public ResponseEntity<LoginRes> login(Authentication authentication) {
//        Object principal = authentication.getPrincipal();
//
//    }

    public ResponseEntity<MemberGetRes> signup(SignUpReq req) {
        if (req == null)
            throw new IllegalArgumentException("잘못된 회원가입 요청입니다.");

        if (memberRepository.existsMemberByEmail(req.getEmail())) {
            throw new IllegalArgumentException("유저가 이미 존재합니다.");
        }

        Member member = Member.builder()
                .nickname(req.getNickname())
                .email(req.getEmail())
                .coverLetter(req.getCoverLetter())
                .level(1)
                .build();

        memberRepository.save(member);

        return new ResponseEntity<>(new MemberGetRes(member), HttpStatus.OK);

    }
}
