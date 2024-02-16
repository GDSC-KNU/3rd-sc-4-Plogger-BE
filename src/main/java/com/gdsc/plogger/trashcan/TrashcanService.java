package com.gdsc.plogger.trashcan;

import com.gdsc.plogger.trashcan.data.Trashcan;
import com.gdsc.plogger.trashcan.data.dto.req.AddTrashcanReq;
import com.gdsc.plogger.trashcan.data.dto.res.TrashcanGetRes;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TrashcanService {
    @Autowired
    private final TrashcanRepository trashcanRepository;
    private final int threshold = 1;

    public ResponseEntity<List<TrashcanGetRes>> getTrashcans() {
        List<Trashcan> trashcans = trashcanRepository.findAll();
        List<TrashcanGetRes> res = new ArrayList<>();

        for(Trashcan trashcan : trashcans) {
            res.add(new TrashcanGetRes(trashcan));
        }

        return ResponseEntity.ok()
                .body(res);
    }

    @Transactional
    public ResponseEntity<List<TrashcanGetRes>> report(Long id) {
        Trashcan trashcan = trashcanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        trashcan.report();

        if(trashcan.getReport() >= threshold) {
            deleteTrashcan(id);
        }

        return getTrashcans();
    }

    public Trashcan addNewTrashcan(AddTrashcanReq request) {
        return trashcanRepository.save(request.toEntity());
    }

    public ResponseEntity<Void> deleteTrashcan(Long id) {
        trashcanRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
