package com.Animal.ShelterTelegramBot.service;

import com.Animal.ShelterTelegramBot.repository.CatShelterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
public class ShelterService {

    private final CatShelterRepository catShelterRepository;

    public String getInfo(Long shelterId) {
        return catShelterRepository.findById(shelterId).toString();
    }
}
