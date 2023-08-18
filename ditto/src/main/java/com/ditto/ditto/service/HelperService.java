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

    // helper 조회
    public HelperDto.Response readHelper(Long helperId) {
        Helper helper = helperRepository.findById(helperId).get();
        List<Long> totalScore= helper.getDonors().stream().map(
                donor -> {
                    return (long)donor.getScore();
                }
        ).collect(Collectors.toList());
        double helpCount = totalScore.size();
        double averageScore = totalScore.stream().mapToLong(Long::longValue).sum() / helpCount;
        return new HelperDto.Response(helper, averageScore, helpCount);
    }
    public List<DonorDto.Response> findAllDonorByHelper(Long helperId) {
        Helper helper = helperRepository.findById(helperId).get();

        return helper.getDonors().stream()
                .map(DonorDto.Response::new)
                .collect(Collectors.toList());
    }
}
