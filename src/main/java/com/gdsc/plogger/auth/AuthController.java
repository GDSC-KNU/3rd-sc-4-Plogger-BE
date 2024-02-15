package com.gdsc.plogger.auth;

import com.gdsc.plogger.auth.data.dto.req.LoginReq;
import com.gdsc.plogger.auth.data.dto.req.SignUpReq;
import com.gdsc.plogger.member.data.dto.res.MemberGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq req) {
        return authService.login(req);
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberGetRes> signup(@RequestBody SignUpReq req) {
        return authService.signup(req);
    }
}
