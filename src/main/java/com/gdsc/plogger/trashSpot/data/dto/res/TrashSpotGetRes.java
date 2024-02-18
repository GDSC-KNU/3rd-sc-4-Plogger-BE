package com.gdsc.plogger.trashSpot.data.dto.res;

import com.gdsc.plogger.trashSpot.data.TrashSpot;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class TrashSpotGetRes {
    private Long id;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public TrashSpotGetRes(TrashSpot trashSpot) {
        this.id = trashSpot.getId();
        this.latitude = trashSpot.getLatitude();
        this.longitude = trashSpot.getLongitude();
    }
}
