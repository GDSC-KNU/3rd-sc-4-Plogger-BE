package com.gdsc.plogger.member.data.dto.res;

import com.gdsc.plogger.member.data.Member;
import lombok.Data;

@Data
public class MemberGetRes {

    private String nickname;
    private String email;
    private String coverLetter;
    private String profileImage;

    public MemberGetRes(Member member) {
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.coverLetter = member.getCoverLetter();
        this.profileImage = member.getProfileImage();
    }
}
