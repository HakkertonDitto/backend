package com.ditto.ditto.dto;

import com.ditto.ditto.entity.Category;
import com.ditto.ditto.entity.HelpSeeker;
import com.ditto.ditto.entity.HelpType;
import lombok.*;

public class HelpTypeDto {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        private Category category;
        private String detail;
        public HelpType toEntity(HelpSeeker helpSeeker){
            return HelpType.builder()
                    .category(category)
                    .detail(detail)
                    .helpSeeker(helpSeeker)
                    .build();
        }
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private Category category;
        private String detail;

        public Response(HelpType helpType) {
            this.id = helpType.getId();
            this.category = helpType.getCategory();
            this.detail = helpType.getDetail();
        }
    }
}
