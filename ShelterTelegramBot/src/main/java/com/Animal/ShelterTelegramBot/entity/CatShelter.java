package com.Animal.ShelterTelegramBot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cat_shelter")
@Getter
@Setter
@AllArgsConstructor
public class CatShelter implements Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public String getGuardData() {
        return null;
    }

    @Override
    public String getRecommendation() {
        return null;
    }

    @Override
    public String getContact() {
        return null;
    }
}
