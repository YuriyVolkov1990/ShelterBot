package com.Animal.ShelterTelegramBot.repository;

import com.Animal.ShelterTelegramBot.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.ListCrudRepository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
