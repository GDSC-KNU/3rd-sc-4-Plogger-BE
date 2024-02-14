package com.gdsc.plogger.trashCan;

import com.gdsc.plogger.trashCan.data.Trashcan;
import com.gdsc.plogger.trashCan.data.dto.res.TrashcanGetRes;
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

    public ResponseEntity<List<TrashcanGetRes>> findNoReport() {
        List<Trashcan> trashcans = trashcanRepository.findByReportLessThan(1);
        List<TrashcanGetRes> res = new ArrayList<>();

        for(Trashcan trashcan : trashcans) {
            res.add(new TrashcanGetRes(trashcan));
        }

        return ResponseEntity.ok()
                .body(res);
    }
}
