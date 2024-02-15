package com.gdsc.plogger.trashSpot;

import com.gdsc.plogger.trashSpot.data.TrashSpot;
import com.gdsc.plogger.trashSpot.data.dto.req.AddTrashSpotReq;
import com.gdsc.plogger.trashSpot.data.dto.res.TrashSpotGetRes;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TrashSpotService {
    @Autowired
    TrashSpotRepository trashSpotRepository;

    public ResponseEntity<List<TrashSpotGetRes>> getSpots() {
        List<TrashSpot> trashSpots = trashSpotRepository.findByReportLessThan(1);
        List<TrashSpotGetRes> res = new ArrayList<>();

        for(TrashSpot trashSpot : trashSpots) {
            res.add(new TrashSpotGetRes(trashSpot));
        }

        return ResponseEntity.ok()
                .body(res);
    }

    public ResponseEntity<TrashSpotGetRes> addNewSpot(AddTrashSpotReq req) {
        TrashSpot newSpot = trashSpotRepository.save(req.toEntity());

        return ResponseEntity.status(HttpStatus.CREATED).body(new TrashSpotGetRes(newSpot));
    }
}
