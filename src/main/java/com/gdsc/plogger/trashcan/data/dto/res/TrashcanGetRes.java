package com.gdsc.plogger.trashcan.data.dto.res;

import com.gdsc.plogger.trashcan.data.Trashcan;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class TrashcanGetRes {
    private Long id;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public TrashcanGetRes(Trashcan trashcan) {
        this.id = trashcan.getId();
        this.latitude = trashcan.getLatitude();
        this.longitude = trashcan.getLongitude();
    }
}
