package com.gdsc.plogger.trashCan.data.dto.res;

import com.gdsc.plogger.trashCan.data.Trashcan;
import lombok.Data;

@Data
public class TrashcanGetRes {
    private double latitude;
    private double longitude;

    public TrashcanGetRes(Trashcan trashcan) {
        this.latitude = trashcan.getLatitude();
        this.longitude = trashcan.getLongitude();
    }
}
