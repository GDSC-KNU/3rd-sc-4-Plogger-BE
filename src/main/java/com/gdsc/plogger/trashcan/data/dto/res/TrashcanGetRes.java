package com.gdsc.plogger.trashcan.data.dto.res;

import com.gdsc.plogger.trashcan.data.Trashcan;
import lombok.Data;

@Data
public class TrashcanGetRes {
    private Long id;
    private double latitude;
    private double longitude;

    public TrashcanGetRes(Trashcan trashcan) {
        this.id = trashcan.getId();
        this.latitude = trashcan.getLatitude();
        this.longitude = trashcan.getLongitude();
    }
}
