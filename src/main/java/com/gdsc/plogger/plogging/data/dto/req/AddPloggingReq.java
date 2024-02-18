package com.gdsc.plogger.plogging.data.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.gdsc.plogger.member.data.Member;
import com.gdsc.plogger.plogging.data.Plogging;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;

@Data
public class AddPloggingReq {
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime period;
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
