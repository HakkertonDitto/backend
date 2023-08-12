package com.ditto.ditto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HelpTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "helpType_id")
    private Long id;

    private String category;
    private String detail;

    @OneToOne(mappedBy = "helpTypeEntity")
    private HelpSeekerEntity helpSeekerEntity;
}
