package com.gdsc.plogger.trashcan.data.dto.req;


import com.gdsc.plogger.trashcan.data.Trashcan;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class AddTrashcanReq {
    private BigDecimal latitude;
    private BigDecimal longitude;

    public Trashcan toEntity() {
        return Trashcan.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
