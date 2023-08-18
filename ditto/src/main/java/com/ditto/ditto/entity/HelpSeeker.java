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
public class HelpSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "help_seeker_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "help_type_id")
    private HelpType helpType;
}
