package com.gdsc.plogger.trashSpot.data.dto.req;

import com.gdsc.plogger.trashSpot.data.TrashSpot;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class AddTrashSpotReq {
    private BigDecimal latitude;
    private BigDecimal longitude;

    public TrashSpot toEntity() {
        return TrashSpot.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
