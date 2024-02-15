package com.gdsc.plogger.trashCan;

import com.gdsc.plogger.trashCan.data.Trashcan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashcanRepository extends JpaRepository<Trashcan, Long> {
    List<Trashcan> findByReportLessThan(int report);
}
