package com.Animal.ShelterTelegramBot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "cat_shelter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CatShelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "info")
    private String info;
    @Column(name = "guardData")
    private String guardData;
    @Column(name = "recommendation")
    private String recommendation;
    @Column(name = "contact")
    private String contact;
}
