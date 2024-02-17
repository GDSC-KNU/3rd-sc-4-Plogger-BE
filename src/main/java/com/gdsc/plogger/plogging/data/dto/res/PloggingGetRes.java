package com.gdsc.plogger.plogging.data.dto.res;

import com.gdsc.plogger.plogging.data.Plogging;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PloggingGetRes {
    private Long id;
    private LocalDate date;
    private LocalDateTime period;
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
