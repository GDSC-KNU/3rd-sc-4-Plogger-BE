package com.gdsc.plogger.auth.data.dto.req;

import lombok.Data;

@Data
public class SignUpReq {

    private String nickname;

    private String email;

    private String coverLetter;
}
