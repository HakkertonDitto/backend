package com.ditto.ditto.service;

import com.ditto.ditto.dto.DonorDto;
import com.ditto.ditto.entity.Donor;
import com.ditto.ditto.entity.HelperEntity;
import com.ditto.ditto.repository.HelperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonorService {
    private final HelperRepository helperRepository;
    public void createDonor(DonorDto.Request dto, Long helperId){
        HelperEntity helper = helperRepository.findById(helperId).orElseThrow();
        Donor donor = dto.toEntity(helper);
    }
}
