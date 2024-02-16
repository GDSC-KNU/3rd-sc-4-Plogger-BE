package com.gdsc.plogger.plogging;

import com.gdsc.plogger.plogging.data.dto.res.PloggingGetRes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
