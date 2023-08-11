package com.ditto.ditto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HelperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "helper_id")
    private Long id;
    private String nickname;
    private String phoneNumber;
    private int time;
    private boolean helpOnOff;
    private int point;
    private Long grade;
    private int helpCount;
    @OneToMany(mappedBy = "helperEntity")
    private List<CommentEntity> commentEntity;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;
}
