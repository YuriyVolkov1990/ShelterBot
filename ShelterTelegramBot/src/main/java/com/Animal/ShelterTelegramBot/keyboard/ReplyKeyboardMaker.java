package com.Animal.ShelterTelegramBot.keyboard;

import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import org.springframework.stereotype.Component;


@Component
public class ReplyKeyboardMaker {
    public ReplyKeyboardMarkup getMainMenuKeyboard() {
        KeyboardButton m1 = new KeyboardButton(ButtonNameEnum.CAT.getButtonName());
        KeyboardButton m2 = new KeyboardButton(ButtonNameEnum.DOG.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[2];
        keyboard[0] = m1;
        keyboard[1] = m2;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getCatMenuKeyboard() {
        KeyboardButton c1 = new KeyboardButton(ButtonNameEnum.INFO_CAT.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[1];
        keyboard[0] = c1;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getDogMenuKeyboard() {
        KeyboardButton d1 = new KeyboardButton(ButtonNameEnum.INFO_CAT.getButtonName());
        KeyboardButton[] keyboard = new KeyboardButton[1];
        keyboard[0] = d1;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.selective(true);
        replyKeyboardMarkup.resizeKeyboard(true);
        replyKeyboardMarkup.oneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
}
