package com.ditto.ditto.controller;

import com.ditto.ditto.dto.HelpTypeDto;
import com.ditto.ditto.service.HelpSeekerService;
import com.ditto.ditto.service.HelpTypeSerivce;
import com.ditto.ditto.service.HelperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asker")
@RequiredArgsConstructor
public class HelpSeekerController {
    private final HelpSeekerService helpSeekerService;
    public final HelpTypeSerivce helpTypeSerivce;

    // helpType생성 및 helpSeeker 생성
    @PostMapping
    public ResponseEntity<HelpTypeDto> create(@RequestBody HelpTypeDto helpTypeDto) {
        Long id = helpSeekerService.create();
        HelpTypeDto helpType = helpTypeSerivce.create(id, helpTypeDto);

        return ResponseEntity.ok(helpType);
    }
}
