package com.gdsc.plogger.member;

import com.gdsc.plogger.member.data.Member;
import com.gdsc.plogger.member.data.dto.req.MemberPatchReq;
import com.gdsc.plogger.member.data.dto.res.MemberGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public ResponseEntity<MemberGetRes> getMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        return new ResponseEntity<>(new MemberGetRes(member), HttpStatus.OK);
    }

    public ResponseEntity<MemberGetRes> patchMember(MemberPatchReq patchReq, Long id) {
        if (patchReq == null) throw new IllegalArgumentException("MemberPatchReq가 null입니다.");

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
        member.update(patchReq);
        memberRepository.save(member);

        return new ResponseEntity<>(new MemberGetRes(member), HttpStatus.OK);
    }
}
