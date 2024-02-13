package com.gdsc.plogger.trashCan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Trashcan extends JpaRepository<Trashcan, Long> {
}
