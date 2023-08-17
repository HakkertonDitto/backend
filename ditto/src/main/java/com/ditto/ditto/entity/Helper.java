package com.ditto.ditto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor @Builder
public class Helper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "helper_id")
    private Long id;
    private String nickname;
    private String phoneNumber;
    private int time;
    private boolean helpOnOff;
    private int point;

    @OneToMany(mappedBy = "helper")
    private List<Donor> donors;

}
