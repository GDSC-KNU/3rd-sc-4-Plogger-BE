package com.gdsc.plogger.plogging;

import com.gdsc.plogger.plogging.data.dto.req.AddPloggingReq;
import com.gdsc.plogger.plogging.data.dto.res.PloggingGetRes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plogging")
@RequiredArgsConstructor
public class PloggingController {
    private final PloggingService ploggingService;

    @GetMapping
    public ResponseEntity<List<PloggingGetRes>> getPloggings() {
        return ploggingService.getPloggings();
    }

    @PostMapping
    public ResponseEntity<PloggingGetRes> newPlogging(@RequestBody AddPloggingReq req) {
        return ploggingService.addPlogging(req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlogging(@PathVariable(name = "id") Long id) {
        ploggingService.deletePlogging(id);
        return ResponseEntity.ok().build();
    }
}
