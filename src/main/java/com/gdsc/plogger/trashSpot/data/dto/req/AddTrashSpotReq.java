package com.gdsc.plogger.trashSpot.data.dto.req;

import com.gdsc.plogger.trashSpot.data.TrashSpot;

public class AddTrashSpotReq {
    private double latitude;
    private double longitude;

    public TrashSpot toEntity() {
        return TrashSpot.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
