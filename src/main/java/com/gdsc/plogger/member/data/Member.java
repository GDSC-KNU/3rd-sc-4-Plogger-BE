package com.gdsc.plogger.member.data;

import com.gdsc.plogger.common.BaseEntity;
import com.gdsc.plogger.member.data.dto.req.MemberPatchReq;
import com.gdsc.plogger.plogging.data.Plogging;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Nonnull
    private String nickname;

    @Column(unique = true)
    private String email;

    @Nonnull
    private String coverLetter;

    private String refreshToken;

    private String profileImage;

    private int level;

    private int exp;

    @OneToMany(mappedBy = "member")
    List<Plogging> ploggings = new ArrayList<>();

    @Builder
    public Member(String nickname, String email, String coverLetter, String refreshToken, int level, int exp) {
        this.nickname = nickname;
        this.email = email;
        this.coverLetter = coverLetter;
        this.refreshToken = refreshToken;
        this.level = level;
        this.exp = exp;
    }

    public void update(MemberPatchReq req) {
        this.nickname = req.getNickname();
        this.coverLetter = req.getCoverLetter();
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void updateProfileImage(String profileImage) {
        // if profileImage == null, remove profileImage
        this.profileImage = profileImage;
    }

    public void updateExp(int exp) {
        int maxExp = this.level * 50;
        int totalExp = this.exp + exp;

        this.level += totalExp / maxExp;
        this.exp = totalExp % maxExp;
    }
}
