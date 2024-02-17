package com.gdsc.plogger.plogging.data.dto.req;

import com.gdsc.plogger.member.data.Member;
import com.gdsc.plogger.plogging.data.Plogging;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddPloggingReq {
    private LocalDate date;
    private LocalDateTime period;
    private double distance;
    private int trashCount;

    public Plogging toEntity(Member member) {
        return Plogging.builder()
                .member(member)
                .date(date)
                .period(period)
                .distance(distance)
                .trashCount(trashCount)
                .build();
    }
}
