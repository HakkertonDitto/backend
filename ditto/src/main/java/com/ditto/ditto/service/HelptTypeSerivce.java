package com.ditto.ditto.service;

import com.ditto.ditto.dto.HelpTypeDto;
import com.ditto.ditto.entity.HelpSeekerEntity;
import com.ditto.ditto.entity.HelpTypeEntity;
import com.ditto.ditto.repository.HelpSeekerRepository;
import com.ditto.ditto.repository.HelpTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class HelptTypeSerivce {
    private final HelpTypeRepository helpTypeRepository;
    private final HelpSeekerRepository helpSeekerRepository;

    // 새로운 HelpType 생성 및 저장 후 일치하는 helpSeeker에 저장
    public HelpTypeDto create(Long helpSeekerId, HelpTypeDto helpTypeDto) {
        HelpSeekerEntity helpSeekerEntity = helpSeekerRepository.findById(helpSeekerId).get();

        HelpTypeEntity helpTypeEntity = new HelpTypeEntity();
        helpTypeEntity.setCategory(helpTypeDto.getCategory());
        helpTypeEntity.setDetail(helpTypeDto.getDetail());
        helpTypeEntity.setEtc(helpTypeDto.getEtc());

        helpTypeRepository.save(helpTypeEntity);

        helpSeekerEntity.setHelpTypeEntity(helpTypeEntity);

        return new HelpTypeDto(
                helpTypeEntity.getId(),
                helpTypeEntity.getCategory(),
                helpTypeEntity.getDetail(),
                helpTypeDto.getEtc()
        );
    }

}
