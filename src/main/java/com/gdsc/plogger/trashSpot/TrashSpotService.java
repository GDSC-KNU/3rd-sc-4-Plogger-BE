package com.gdsc.plogger.trashSpot;

import com.gdsc.plogger.trashSpot.data.TrashSpot;
import com.gdsc.plogger.trashSpot.data.dto.req.AddTrashSpotReq;
import com.gdsc.plogger.trashSpot.data.dto.res.TrashSpotGetRes;
import jakarta.transaction.Transactional;
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
    private final int MAX_REPORT = 1;

    public ResponseEntity<List<TrashSpotGetRes>> getSpots() {
        List<TrashSpot> trashSpots = trashSpotRepository.findAll();
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

    @Transactional
    public ResponseEntity<List<TrashSpotGetRes>> reportSpot(Long id) {
        TrashSpot spot = trashSpotRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        spot.report();

        if(spot.getReport() >= MAX_REPORT) {
            deleteSpot(id);
        }

        return getSpots();
    }

    public ResponseEntity<Void> deleteSpot(Long id) {
        trashSpotRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
