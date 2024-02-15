package com.gdsc.plogger.trashSpot;

import com.gdsc.plogger.trashSpot.data.TrashSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashSpotRepository extends JpaRepository<TrashSpot, Long> {
}
