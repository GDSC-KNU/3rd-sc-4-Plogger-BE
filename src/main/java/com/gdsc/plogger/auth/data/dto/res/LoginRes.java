package com.gdsc.plogger.auth.data.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRes {

    private String email;
    private String nickname;
    private String accessToken;
}
