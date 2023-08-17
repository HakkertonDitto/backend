package com.ditto.ditto.service;

import com.ditto.ditto.dto.HelpTypeDto;
import com.ditto.ditto.entity.HelpSeeker;
import com.ditto.ditto.entity.HelpType;
import com.ditto.ditto.repository.HelpSeekerRepository;
import com.ditto.ditto.repository.HelpTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class HelpTypeSerivce {
    private final HelpTypeRepository helpTypeRepository;
    private final HelpSeekerRepository helpSeekerRepository;

    // 새로운 HelpType 생성 및 저장 후 일치하는 helpSeeker에 저장
    public HelpTypeDto.Response create(Long helpSeekerId, HelpTypeDto.Request helpTypeDto) {
        HelpSeeker helpSeeker = helpSeekerRepository.findById(helpSeekerId).get();
        HelpType helpType = helpTypeDto.toEntity(helpSeeker);
        helpTypeRepository.save(helpType);
        return new HelpTypeDto.Response(helpType);
    }


    public List<HelpTypeDto.Response> readAll() {
        List<HelpType> helpTypeList = helpTypeRepository.findAll();

        return helpTypeList.stream()
                .map(HelpTypeDto.Response::new)
                .collect(Collectors.toList());
    }
}
