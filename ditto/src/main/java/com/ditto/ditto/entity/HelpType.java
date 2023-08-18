package com.ditto.ditto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HelpType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "help_type_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String detail;

    @OneToOne(mappedBy = "helpType")
    private HelpSeeker helpSeeker;
}
