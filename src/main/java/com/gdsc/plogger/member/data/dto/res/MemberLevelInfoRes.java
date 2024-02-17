package com.gdsc.plogger.member.data.dto.res;

import com.gdsc.plogger.member.data.Member;
import lombok.Data;

@Data
public class MemberLevelInfoRes {
    private String nickname;
    private int level;
    private int exp;

    public MemberLevelInfoRes(Member member) {
        this.nickname = getNickname();
        this.level = getLevel();
        this.exp = getExp();
    }
}
