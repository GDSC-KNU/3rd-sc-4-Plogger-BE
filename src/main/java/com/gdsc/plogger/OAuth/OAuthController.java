package com.gdsc.plogger.OAuth;

import com.gdsc.plogger.auth.data.dto.res.LoginRes;
import com.gdsc.plogger.config.jwt.JwtProvider;
import com.gdsc.plogger.member.MemberRepository;
import com.gdsc.plogger.member.data.Member;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OAuthController {
    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    @PostMapping("/api/oauth/google")
    public ResponseEntity<LoginRes> oauthGoogle(@RequestBody Map<String, Object> data) {
        GoogleUser user = new GoogleUser((Map<String, Object>) data.get("profileObj"));
        Member member;

        try {
            member = memberRepository.findByEmail(user.getEmail())
                    .orElseThrow(() -> new IllegalArgumentException());

        } catch (IllegalArgumentException e) {
            member = Member.builder()
                        .nickname(user.getName())
                        .email(user.getEmail())
                        .level(1)
                        .exp(0)
                        .build();

            member.updateProfileImage(user.getPhoto());

            memberRepository.save(member);
        }

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
}
