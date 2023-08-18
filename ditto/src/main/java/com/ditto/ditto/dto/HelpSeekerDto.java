package com.ditto.ditto.dto;

import com.ditto.ditto.entity.HelpType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HelpSeekerDto {
    private Long id;
    private HelpType helpType;
}
