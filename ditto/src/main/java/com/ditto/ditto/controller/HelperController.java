package com.ditto.ditto.controller;

import com.ditto.ditto.dto.DonorDto;
import com.ditto.ditto.dto.HelpTypeDto;
import com.ditto.ditto.dto.HelperDto;
import com.ditto.ditto.service.HelpSeekerService;
import com.ditto.ditto.service.HelpTypeSerivce;
import com.ditto.ditto.service.HelperService;
import com.ditto.ditto.webrtc.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/help")
@RequiredArgsConstructor
public class HelperController {
    private final HelperService helperService;
    private final HelpSeekerService helpSeekerService;
    private final HelpTypeSerivce helpTypeSerivce;
    private final MainService mainService;

    //helper 생성
    @PostMapping
    public void create(@RequestBody HelperDto.Request helperDto) {
        helperService.create(helperDto);
    }

    // helpType 조회
    @GetMapping("/list")
    public List<HelpTypeDto.Response> readHelpTypeList() {
        List<HelpTypeDto.Response> helpTypeDtoList = helpTypeSerivce.readAll();
        List<HelpTypeDto.Response> filterList = new ArrayList<>();

        for (HelpTypeDto.Response helpTypeDto : helpTypeDtoList) {
            filterList.add(helpTypeDto);
        }

        return filterList;
    }

    // 수락 누르면 바로 방으로 입장, api 경로 수정해야할듯
    @GetMapping("/call/{helpSeekerId}")
    public ModelAndView call(@PathVariable("helpSeekerId") Long helpSeekerId) {
        int randomNumber = (int)(Math.random() * (101) + 100);
        return this.mainService.displaySelectedRoom(helpSeekerId.toString(), Integer.toString(randomNumber));
    }

    //평점, 포인트, 도움 횟수 조회
    @GetMapping("/helper/{helperId}")
    public ResponseEntity<HelperDto.Response> readHelper(@PathVariable("helperId") Long helperId) {
        return ResponseEntity.ok(
                helperService.readHelper(helperId)
        );
    }

    // 코멘트 확인
    @GetMapping("/helper/{helperId}/donor")
    public ResponseEntity<List<DonorDto.Response>> readComment(@PathVariable("helperId") Long helperId) {

        return ResponseEntity.ok(
          helperService.findAllDonorByHelper(helperId)
        );
    }
}
