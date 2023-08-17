package com.ditto.ditto.service;

import com.ditto.ditto.dto.DonorDto;
import com.ditto.ditto.dto.HelperDto;
import com.ditto.ditto.entity.Donor;
import com.ditto.ditto.entity.Helper;
import com.ditto.ditto.repository.HelperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class HelperService {
    private final HelperRepository helperRepository;

    //helper 생성
    public void create(HelperDto.Request helperDto) {
        Helper helper = helperDto.toEntity();
        helperRepository.save(helper);
    }

    // 포인트, 봉사시간, 도움 횟수 조회
    public HelperDto.Response readPoint(Long helperId) {
        Helper helper = helperRepository.findById(helperId).get();
        List<Long> totalScore= helper.getDonors().stream().map(
                donor -> {
                    return (long)donor.getScore();
                }
        ).collect(Collectors.toList());
        double averageScore = totalScore.stream().mapToLong(Long::longValue).sum() / totalScore.size();
        return new HelperDto.Response(helper, helpCount, averageScore);
    }
    public double getTotalScore(Helper helper){
        List<Long> totalScore= helper.getDonors().stream().map(
                donor -> {
                    return (long)donor.getScore();
                }
        ).collect(Collectors.toList());
        return totalScore.stream().mapToLong(Long::longValue).sum();
    }
    public List<DonorDto.Response> findAllDonorByHelper(Long helperId) {
        Helper helper = helperRepository.findById(helperId).get();

        return helper.getDonors().stream()
                .map(DonorDto.Response::new)
                .collect(Collectors.toList());
    }

    // helper 조회
    public HelperDto read(Long helperId) {
        Helper helperEntity = helperRepository.findById(helperId).get();

        return new HelperDto(
                helperEntity.getId(),
                helperEntity.getNickname(),
                helperEntity.getPhoneNumber(),
                helperEntity.getTime(),
                helperEntity.isHelpOnOff(),
                helperEntity.getPoint(),
                helperEntity.getHelpCount(),
                helperEntity.getScores().stream()
                                        .mapToLong(Long::longValue)
                                        .average()
                                        .orElse(0.0));
    }
}
