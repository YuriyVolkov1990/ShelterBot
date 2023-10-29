package com.Animal.ShelterTelegramBot.listener;

import com.Animal.ShelterTelegramBot.entity.CatShelter;
import com.Animal.ShelterTelegramBot.keyboard.ReplyKeyboardMaker;
import com.Animal.ShelterTelegramBot.service.ShelterService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ShelterBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(ShelterBotUpdatesListener.class);
    @Autowired
    private ReplyKeyboardMaker replyKeyboardMaker;
    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    private ShelterService shelterService;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("/start".equalsIgnoreCase(text)) {
                SendMessage sendMessage = new SendMessage(chatId, "Выберите приют");
                sendMessage.replyMarkup(replyKeyboardMaker.getMainMenuKeyboard());
                telegramBot.execute(sendMessage);
            }
            switch (text) {
                case "Выбрать приют для кошек"->
                    catMenu(updates);
                case "Выбрать приют для собак"->
                    dogMenu(updates);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void catMenu (List<Update> updates) {
        updates.forEach(update -> {
        String text = update.message().text();
        Long chatId = update.message().chat().id();
        if ("Выбрать приют для кошек".equalsIgnoreCase(text)) {
            SendMessage catMessage = new SendMessage(chatId, "Вы выбрали кошачий приют");
            catMessage.replyMarkup(replyKeyboardMaker.getCatMenuKeyboard());
            telegramBot.execute(catMessage);
            SendMessage infoMessage = new SendMessage(chatId, shelterService.getInfo(1L));
            telegramBot.execute(infoMessage);
        }
//        if ("Инфо про кошачий приют".equalsIgnoreCase(text)) {
//            SendMessage infoMessage = new SendMessage(chatId, shelterService.getInfo(1L));
//            telegramBot.execute(infoMessage);
//        }
    });
    }
    private void dogMenu (List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("Выбрать приют для кошек".equalsIgnoreCase(text)) {
                SendMessage dogMessage = new SendMessage(chatId, "Вы выбрали собачий приют");
                dogMessage.replyMarkup(replyKeyboardMaker.getDogMenuKeyboard());
                telegramBot.execute(dogMessage);
            }
        });
    }
}
