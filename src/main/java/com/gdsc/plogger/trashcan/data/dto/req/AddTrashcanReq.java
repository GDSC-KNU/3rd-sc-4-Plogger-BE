package com.gdsc.plogger.trashcan.data.dto.req;

import com.gdsc.plogger.trashcan.data.Trashcan;

public class AddTrashcanReq {
    private double latitude;
    private double longitude;

    public Trashcan toEntity() {
        return Trashcan.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
