package com.ditto.ditto.dto;

import com.ditto.ditto.entity.Donor;
import com.ditto.ditto.entity.Helper;
import lombok.*;

public class DonorDto {
    @Data @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        Long callTime;
        Long score;
        String comment;
        public Donor toEntity(Helper helper){
            return Donor.builder()
                    .callTime(callTime)
                    .score(score)
                    .comment(comment)
                    .helper(helper)
                    .build();
        }
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response{
        Long id;
        Long callTime;
        Long score;
        String comment;
        String userName;
        public Response(Donor donor){
            this.id = donor.getId();
            this.callTime = donor.getCallTime();
            this.score = donor.getScore();
            this.comment = donor.getComment();
            this.userName = donor.getHelper().getNickname();
        }
    }
}
