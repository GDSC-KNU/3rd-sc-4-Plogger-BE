package com.gdsc.plogger.trashcan;

import com.gdsc.plogger.trashcan.data.Trashcan;
import com.gdsc.plogger.trashcan.data.dto.req.AddTrashcanReq;
import com.gdsc.plogger.trashcan.data.dto.res.TrashcanGetRes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
        return trashcanService.getTrashcans();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<List<TrashcanGetRes>> report(@PathVariable(name = "id") Long id) {
        return trashcanService.report(id);
    }

    @PostMapping
    public ResponseEntity<TrashcanGetRes> addNewTrashcan(AddTrashcanReq request) {
        Trashcan trashcan = trashcanService.addNewTrashcan(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new TrashcanGetRes(trashcan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        return trashcanService.deleteTrashcan(id);
    }
}
