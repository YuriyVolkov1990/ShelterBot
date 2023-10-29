package com.Animal.ShelterTelegramBot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ShelterBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(ShelterBotUpdatesListener.class);
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
                SendMessage sendMessage = new SendMessage(chatId, "HI");
                telegramBot.execute(sendMessage);
            }
//            } else if (matcher.matches()) {
//                String dateStr = matcher.group(1);
//                LocalDateTime execDate = LocalDateTime.parse(dateStr, FORMATTER);
//                String message = matcher.group(2);
//                NotificationTask task = new NotificationTask();
//                task.setChatId(chatId);
//                task.setMessage(message);
//                task.setExecDate(execDate);
//                repository.save(task);
//                sendMessage(chatId, "Событие сохранено на дату " + execDate);
//            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
    private SendResponse sendMessage(Long chatId, String message) {
        SendMessage send = new SendMessage(chatId, message);
        return telegramBot.execute(send);
    }
}
