package com.gdsc.plogger.plogging;

import com.gdsc.plogger.ExpInfo;
import com.gdsc.plogger.member.MemberRepository;
import com.gdsc.plogger.member.data.Member;
import com.gdsc.plogger.plogging.data.Plogging;
import com.gdsc.plogger.plogging.data.dto.req.AddPloggingReq;
import com.gdsc.plogger.plogging.data.dto.res.PloggingGetRes;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PloggingService {
    @Autowired
    private final PloggingRepository ploggingRepository;

    @Autowired
    private final MemberRepository memberRepository;

    public ResponseEntity<List<PloggingGetRes>> getPloggings() {
        List<Plogging> ploggings = ploggingRepository.findAllByMember(getMember());
        List<PloggingGetRes> res = new ArrayList<>();

        for(Plogging plogging : ploggings) {
            res.add(new PloggingGetRes(plogging));
        }

        return ResponseEntity.ok()
                .body(res);
    }

    @Transactional
    public ResponseEntity<PloggingGetRes> addPlogging(AddPloggingReq req) {
        Member member = getMember();
        Plogging newPlogging = ploggingRepository.save(req.toEntity(member));

        int exp = newPlogging.getTrashCount() * ExpInfo.TRASH.getExpInfo() + ExpInfo.PLOGGING.getExpInfo();

        member.updateExp(exp);

        return ResponseEntity.status(HttpStatus.CREATED).body(new PloggingGetRes(newPlogging));
    }

    public void deletePlogging(Long id) {
        Plogging plogging = ploggingRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 일지가 존재하지 않습니다"));

        if(!plogging.getMember().equals(getMember())) {
            throw new IllegalArgumentException("not authorized");
        }

        ploggingRepository.delete(plogging);
    }

    private Member getMember() {
        Long memberId = Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다"));

        return member;
    }
}
