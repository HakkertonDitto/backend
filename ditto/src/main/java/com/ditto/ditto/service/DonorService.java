package com.ditto.ditto.service;

import com.ditto.ditto.dto.DonorDto;
import com.ditto.ditto.entity.Donor;
import com.ditto.ditto.entity.HelperEntity;
import com.ditto.ditto.repository.DonorRepository;
import com.ditto.ditto.repository.HelperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DonorService {
    private final HelperRepository helperRepository;
    private final DonorRepository donorRepository;
    public void createDonor(DonorDto.Request dto, Long helperId){
        HelperEntity helper = helperRepository.findById(helperId).orElseThrow();
        Donor donor = dto.toEntity(helper);
    }
    public List<DonorDto.Response> getAllByHelper(Long helperId){
        HelperEntity helper = helperRepository.findById(helperId).orElseThrow();
        String userName = helper.getNickname();
        return donorRepository.findAllByHelperEntity(helper).stream().map(DonorDto.Response::new).collect(Collectors.toList());
    }
}
