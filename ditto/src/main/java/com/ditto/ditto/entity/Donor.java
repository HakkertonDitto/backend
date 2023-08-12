package com.ditto.ditto.entity;

import com.ditto.ditto.dto.DonorDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long callTime;
    Long score;
    String comment;
    @OneToOne
    HelperEntity helperEntity;

}
