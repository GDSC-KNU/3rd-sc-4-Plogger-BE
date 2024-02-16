package com.gdsc.plogger.plogging;

import com.gdsc.plogger.plogging.data.Plogging;
import com.gdsc.plogger.plogging.data.dto.req.AddPloggingReq;
import com.gdsc.plogger.plogging.data.dto.res.PloggingGetRes;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PloggingService {
    @Autowired
    private final PloggingRepository ploggingRepository;

    public ResponseEntity<List<PloggingGetRes>> getPloggings() {
        List<Plogging> ploggings = ploggingRepository.findAll();
        List<PloggingGetRes> res = new ArrayList<>();

        for(Plogging plogging : ploggings) {
            res.add(new PloggingGetRes(plogging));
        }

        return ResponseEntity.ok()
                .body(res);
    }

    public ResponseEntity<PloggingGetRes> addPlogging(AddPloggingReq req) {
        Plogging newPlogging = ploggingRepository.save(req.toEntity());

        return ResponseEntity.status(HttpStatus.CREATED).body(new PloggingGetRes(newPlogging));
    }
}
