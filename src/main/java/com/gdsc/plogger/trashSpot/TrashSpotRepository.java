package com.gdsc.plogger.trashSpot;

import com.gdsc.plogger.trashSpot.data.TrashSpot;
import com.gdsc.plogger.trashcan.data.Trashcan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashSpotRepository extends JpaRepository<TrashSpot, Long> {
    List<TrashSpot> findByReportLessThan(int report);
}
