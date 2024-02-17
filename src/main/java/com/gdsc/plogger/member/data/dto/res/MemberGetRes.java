package com.gdsc.plogger.member.data.dto.res;

import com.gdsc.plogger.member.data.Member;
import lombok.Data;

@Data
public class MemberGetRes {

    private String nickname;
    private String email;
    private String coverLetter;
    private String profileImage;
    private int level;
    private int exp;

    public MemberGetRes(Member member) {
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.coverLetter = member.getCoverLetter();
        this.profileImage = member.getProfileImage();
        this.level = member.getLevel();
        this.exp = member.getExp();
    }
}
