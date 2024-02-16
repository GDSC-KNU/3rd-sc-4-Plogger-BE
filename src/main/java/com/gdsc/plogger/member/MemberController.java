package com.gdsc.plogger.member;

import com.gdsc.plogger.member.data.dto.req.MemberPatchReq;
import com.gdsc.plogger.member.data.dto.res.MemberGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<MemberGetRes> getMember(Authentication authentication) {
        return memberService.getMember(authentication);
    }

    @PatchMapping
    public ResponseEntity<MemberGetRes> patchMember(@RequestBody MemberPatchReq patchReq, Authentication authentication) {
        return memberService.patchMember(patchReq, authentication);
    }
}
