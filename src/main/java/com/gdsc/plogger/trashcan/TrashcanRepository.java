package com.gdsc.plogger.trashcan;

import com.gdsc.plogger.trashcan.data.Trashcan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashcanRepository extends JpaRepository<Trashcan, Long> {
    List<Trashcan> findByReportLessThan(int report);
}
