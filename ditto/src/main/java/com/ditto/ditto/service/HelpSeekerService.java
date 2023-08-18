package com.ditto.ditto.service;

import com.ditto.ditto.dto.HelpSeekerDto;
import com.ditto.ditto.entity.HelpSeeker;
import com.ditto.ditto.repository.HelpSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HelpSeekerService {
    private final HelpSeekerRepository helpSeekerRepository;

    // 새로운 HelpSeeker 객체 생성 후 저장
    public Long create() {
        HelpSeeker helpSeekerEntity = new HelpSeeker();
        helpSeekerRepository.save(helpSeekerEntity);

        return helpSeekerEntity.getId();
    }

    // HelpSeeker 조회
    public HelpSeekerDto read(Long id) {
        HelpSeeker helpSeeker = helpSeekerRepository.findById(id).get();

        return new HelpSeekerDto(
                helpSeeker.getId(),
                helpSeeker.getHelpType()
        );
    }
}
