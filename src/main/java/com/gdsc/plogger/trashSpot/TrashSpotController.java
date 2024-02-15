package com.gdsc.plogger.trashSpot;

import com.gdsc.plogger.trashSpot.data.dto.res.TrashSpotGetRes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trashspot")
public class TrashSpotController {
    private final TrashSpotService trashSpotService;

    @GetMapping
    public ResponseEntity<List<TrashSpotGetRes>> getAllSpots() {
        return trashSpotService.getAllSpots();
    }
}
