package com.ditto.ditto.controller;

import com.ditto.ditto.dto.HelpSeekerDto;
import com.ditto.ditto.dto.HelpTypeDto;
import com.ditto.ditto.entity.HelpTypeEntity;
import com.ditto.ditto.service.HelpSeekerService;
import com.ditto.ditto.service.HelperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/helper")
@RequiredArgsConstructor
public class HelperController {
    private final HelperService helperService;
    private final HelpSeekerService helpSeekerService;

    // helpType 조회
    @GetMapping("/{helperId}/{helpSeekerId}")
    public ResponseEntity<HelpTypeDto> readHelpType(@PathVariable("helpSeekerId") Long helpSeekerId) {
        HelpSeekerDto helpSeekerDto = helpSeekerService.read(helpSeekerId);
        HelpTypeEntity helpTypeEntity = helpSeekerDto.getHelpTypeEntity();
        HelpTypeDto helpTypeDto = new HelpTypeDto(
                helpTypeEntity.getId(),
                helpTypeEntity.getCategory(),
                helpTypeEntity.getDetail(),
                helpTypeEntity.getEtc());

        return ResponseEntity.ok(helpTypeDto);
    }

}
