package com.ditto.ditto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HelperDto {
    private Long id;
    private String nickname;
    private String phoneNumber;
    private int time;
    private boolean helpOnOff;
    private int point;
    private Long grade;
    private int helpCount;
}