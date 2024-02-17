package com.gdsc.plogger.plogging;

import com.gdsc.plogger.member.data.Member;
import com.gdsc.plogger.plogging.data.Plogging;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PloggingRepository extends JpaRepository<Plogging, Long> {
    List<Plogging> findAllByMember(Member member);
}
