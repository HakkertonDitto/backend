package com.ditto.ditto.dto;

import com.ditto.ditto.entity.HelpTypeEntity;
import jakarta.persistence.Entity;
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
    private HelpTypeEntity helpTypeEntity;
}
