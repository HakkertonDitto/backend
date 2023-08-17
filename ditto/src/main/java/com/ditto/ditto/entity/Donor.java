package com.ditto.ditto.entity;

import com.ditto.ditto.dto.DonorDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@Entity @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long callTime;
    Long score;
    String comment;
    @ManyToOne
    HelperEntity helperEntity;

}
