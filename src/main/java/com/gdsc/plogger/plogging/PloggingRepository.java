package com.gdsc.plogger.plogging;

import com.gdsc.plogger.plogging.data.Plogging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PloggingRepository extends JpaRepository<Plogging, Long> {
}
