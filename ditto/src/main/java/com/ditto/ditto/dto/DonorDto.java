package com.ditto.ditto.dto;

import com.ditto.ditto.entity.Donor;
import com.ditto.ditto.entity.HelperEntity;
import lombok.*;

public class DonorDto {
    @Data @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        Long callTime;
        Long score;
        String comment;
        public Donor toEntity(HelperEntity helperEntity){
            return Donor.builder()
                    .callTime(callTime)
                    .score(score)
                    .comment(comment)
                    .helperEntity(helperEntity)
                    .build();
        }
    }
    @Getter
    public static class Response{
        Long id;
        Long callTime;
        Long score;
        String comment;
        String userName;
    }
}
