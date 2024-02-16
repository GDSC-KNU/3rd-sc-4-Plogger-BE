package com.gdsc.plogger.trashSpot.data.dto.res;

import com.gdsc.plogger.trashSpot.data.TrashSpot;
import lombok.Data;

@Data
public class TrashSpotGetRes {
    private Long id;
    private double latitude;
    private double longitude;

    public TrashSpotGetRes(TrashSpot trashSpot) {
        this.id = trashSpot.getId();
        this.latitude = trashSpot.getLatitude();
        this.longitude = trashSpot.getLongitude();
    }
}
