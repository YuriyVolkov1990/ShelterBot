package com.Animal.ShelterTelegramBot.config;

import com.Animal.ShelterTelegramBot.entity.CatShelter;
import com.Animal.ShelterTelegramBot.repository.CatShelterRepository;
import com.Animal.ShelterTelegramBot.service.ShelterService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShelterBotConfiguration {

    @Value("${telegram.bot.token}")
    private String token;
    private CatShelterRepository catShelterRepository;

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        return bot;
    }
    @Bean
    public ShelterService shelterService() {
        return new ShelterService(catShelterRepository);
    }
}
