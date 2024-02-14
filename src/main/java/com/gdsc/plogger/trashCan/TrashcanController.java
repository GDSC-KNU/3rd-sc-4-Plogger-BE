package com.gdsc.plogger.trashCan;

import com.gdsc.plogger.trashCan.data.Trashcan;
import com.gdsc.plogger.trashCan.data.dto.res.TrashcanGetRes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trashcan")
public class TrashcanController {
    private final TrashcanService trashcanService;

    @GetMapping
    public ResponseEntity<List<TrashcanGetRes>> getTrashcans() {
        return trashcanService.findNoReport();
    }

    @PostMapping("/{id}")
    public ResponseEntity<List<TrashcanGetRes>> report(@PathVariable(name = "id") Long id) {
        return trashcanService.report(id);
    }
}
