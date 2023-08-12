package com.ditto.ditto.controller;

import com.ditto.ditto.dto.DonorDto;
import com.ditto.ditto.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/donor")
public class DonorController {
    private final DonorService donorService;
    @PostMapping("/{helperId}")
    public ResponseEntity<HttpStatus> createDonor(DonorDto.Request dto, @PathVariable(name = "helperId") Long helperId){
        donorService.createDonor(dto, helperId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{helperId}")
    public ResponseEntity<List<DonorDto.Response>> getDonorAllByHelper(@PathVariable(name = "helperId") Long helperId){
        return new ResponseEntity<>(donorService.getAllByHelper(helperId), HttpStatus.OK);
    }
}
