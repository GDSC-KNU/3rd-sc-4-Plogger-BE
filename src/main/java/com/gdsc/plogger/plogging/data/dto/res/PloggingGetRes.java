package com.gdsc.plogger.plogging.data.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.gdsc.plogger.plogging.data.Plogging;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;

@Data
public class PloggingGetRes {
    private Long id;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime period;
    private double distance;
    private int trashCount;

    public PloggingGetRes(Plogging plogging) {
        this.id = plogging.getId();
        this.date = plogging.getDate();
        this.period = plogging.getPeriod();
        this.distance = plogging.getDistance();
        this.trashCount = plogging.getTrashCount();
    }
}
