package com.ditto.ditto.controller;

import com.ditto.ditto.dto.HelpTypeDto;
import com.ditto.ditto.service.HelpTypeSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/helpSeeker")
@RequiredArgsConstructor
public class HelpTypeController {
    /*public final HelpTypeSerivce helpTypeSerivce;

    //helpType 저장
    @PostMapping("/{helpSeekerId}")
    public ResponseEntity<HelpTypeDto> createCategory(@PathVariable("helpSeekerId") Long helpSeekerId, @RequestBody HelpTypeDto helpTypeDto) {
        HelpTypeDto helpType = helpTypeSerivce.create(helpSeekerId, helpTypeDto);

        return ResponseEntity.ok(helpType);
    }*/
}
