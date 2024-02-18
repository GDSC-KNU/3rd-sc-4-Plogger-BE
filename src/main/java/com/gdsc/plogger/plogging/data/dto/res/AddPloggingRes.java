package com.gdsc.plogger.plogging.data.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.gdsc.plogger.plogging.data.Plogging;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
public class AddPloggingRes {
    private Long id;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime period;
    private double distance;
    private int trashCount;
    private int level;
    private int exp;

    public AddPloggingRes(Plogging plogging) {
        this.id = plogging.getId();
        this.date = plogging.getDate();
        this.period = plogging.getPeriod();
        this.distance = plogging.getDistance();
        this.trashCount = plogging.getTrashCount();
        this.level = plogging.getMember().getLevel();
        this.exp = plogging.getMember().getExp();
    }
}
