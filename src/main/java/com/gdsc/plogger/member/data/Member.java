package com.gdsc.plogger.member.data;

import com.gdsc.plogger.common.BaseEntity;
import com.gdsc.plogger.member.data.dto.req.MemberPatchReq;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nickname;
    private String email;
    private String coverLetter;
    private String refreshToken;
    private String profileImage;

    @Builder
    public Member(String nickname, String email, String coverLetter, String refreshToken) {
        this.nickname = nickname;
        this.email = email;
        this.coverLetter = coverLetter;
        this.refreshToken = refreshToken;
    }

    public void update(MemberPatchReq req) {
        this.nickname = req.getNickname();
        this.coverLetter = req.getCoverLetter();
    }

    public void updateProfileImage(String profileImage) {
        // if profileImage == null, remove profileImage
        this.profileImage = profileImage;
    }
}
