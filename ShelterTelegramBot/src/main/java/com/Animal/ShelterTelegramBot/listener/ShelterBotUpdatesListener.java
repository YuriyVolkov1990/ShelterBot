package com.Animal.ShelterTelegramBot.listener;

import com.Animal.ShelterTelegramBot.keyboard.ReplyKeyboardMaker;
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
    ReplyKeyboardMaker replyKeyboardMaker;
    @Autowired
    private TelegramBot telegramBot;
//    @Autowired
//    private NotificationTaskRepository repository;

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
            SendMessage catMessage = new SendMessage(chatId, "Вы выбрали кошачий приют, вы можете: /info");
            catMessage.replyMarkup(replyKeyboardMaker.getCatMenuKeyboard());
            telegramBot.execute(catMessage);
        }
    });
    }
    private void dogMenu (List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("Выбрать приют для кошек".equalsIgnoreCase(text)) {
                SendMessage sendMessage1 = new SendMessage(chatId, "Вы выбрали собачий приют, вы можете: /info");
                sendMessage1.replyMarkup(replyKeyboardMaker.getDogMenuKeyboard());
                telegramBot.execute(sendMessage1);
            }
        });
    }
}
