package com.ditto.ditto.dto;

import com.ditto.ditto.entity.Donor;
import com.ditto.ditto.entity.Helper;
import lombok.*;

public class HelperDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        private String nickname;
        private String phoneNumber;
        private boolean helpOnOff;
        public Helper toEntity(){
            return Helper.builder()
                    .nickname(nickname)
                    .phoneNumber(phoneNumber)
                    .time(0)
                    .helpOnOff(helpOnOff)
                    .point(0)
                    .build();
        }
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String nickname;
        private String phoneNumber;
        private int time;
        private boolean helpOnOff;
        private int point;

        private double helpCount;
        private double averageScore;

        public Response(Helper helper, double averageScore, double helpCount) {
            this.id = helper.getId();
            this.nickname = helper.getNickname();
            this.phoneNumber = helper.getPhoneNumber();
            this.time = helper.getTime();
            this.helpOnOff = helper.isHelpOnOff();
            this.point = helper.getPoint();
            this.helpCount = helpCount;
            this.averageScore = averageScore;
        }
    }
}
