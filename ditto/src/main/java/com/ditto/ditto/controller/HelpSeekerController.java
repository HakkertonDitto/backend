package com.ditto.ditto.controller;

import com.ditto.ditto.dto.HelpTypeDto;
import com.ditto.ditto.service.HelpSeekerService;
import com.ditto.ditto.service.HelpTypeSerivce;
import com.ditto.ditto.service.HelperService;
import com.ditto.ditto.webrtc.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/asker")
@RequiredArgsConstructor
public class HelpSeekerController {
    private final HelpSeekerService helpSeekerService;
    public final HelpTypeSerivce helpTypeSerivce;
    private final MainService mainService;

    // helpType생성 및 helpSeeker 생성
    @PostMapping
    public ModelAndView create(@RequestBody HelpTypeDto helpTypeDto) {
        Long id = helpSeekerService.create();
        HelpTypeDto helpType = helpTypeSerivce.create(id, helpTypeDto);
        mainService.processRoomSelection(id.toString(), id.toString());
        return this.mainService.displaySelectedRoom(id.toString(), id.toString());
    }
}
