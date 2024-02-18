package com.gdsc.plogger.plogging.data;

import com.gdsc.plogger.member.data.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Plogging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDate date;
    private LocalTime period;
    private double distance;
    private int trashCount;

    @Builder
    public Plogging(Member member, LocalDate date, LocalTime period, double distance, int trashCount) {
        this.member = member;
        this.date = date;
        this.period = period;
        this.distance = distance;
        this.trashCount = trashCount;
        member.getPloggings().add(this);
    }
}
