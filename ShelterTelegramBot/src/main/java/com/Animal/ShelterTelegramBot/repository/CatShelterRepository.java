package com.Animal.ShelterTelegramBot.repository;

import com.Animal.ShelterTelegramBot.entity.CatShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CatShelterRepository extends JpaRepository<CatShelter, Long> {
}
