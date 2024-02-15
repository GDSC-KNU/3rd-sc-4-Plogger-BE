package com.gdsc.plogger.trashCan;

import com.gdsc.plogger.trashCan.data.Trashcan;
import com.gdsc.plogger.trashCan.data.dto.req.AddTrashcanReq;
import com.gdsc.plogger.trashCan.data.dto.res.TrashcanGetRes;
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
public class TrashcanService {
    @Autowired
    private final TrashcanRepository trashcanRepository;

    public ResponseEntity<List<TrashcanGetRes>> findNoReport() {
        List<Trashcan> trashcans = trashcanRepository.findByReportLessThan(1);
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

        return findNoReport();
    }

    public Trashcan addNewTrashcan(AddTrashcanReq request) {
        return trashcanRepository.save(request.toEntity());
    }
}
