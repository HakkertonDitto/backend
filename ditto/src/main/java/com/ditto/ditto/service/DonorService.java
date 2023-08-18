package com.ditto.ditto.service;

import com.ditto.ditto.dto.DonorDto;
import com.ditto.ditto.entity.Donor;
import com.ditto.ditto.entity.Helper;
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
    //Helper에 Score 받은 걸 List로 갖고 있으면 바로 업데이트 되고, average 구할 수 있음
    public void createDonor(DonorDto.Request dto, Long helperId){
        Helper helper = helperRepository.findById(helperId).orElseThrow();
        Donor donor = dto.toEntity(helper);
        helper.getDonors().add(donor);
        donorRepository.save(donor);
        helperRepository.save(helper);
    }
    public List<DonorDto.Response> getAllByHelper(Long helperId){
        Helper helper = helperRepository.findById(helperId).orElseThrow();
        return donorRepository.findAllByHelper(helper).stream().map(DonorDto.Response::new).collect(Collectors.toList());
    }

}
