package com.github.andyvlasenko.telegrambot.services;

import com.github.andyvlasenko.telegrambot.config.BotConfig;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//TODO Move to WebHook
@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {
    final BotConfig botConfig;

    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    public String getBotToken() {
        return botConfig.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String originalMessage = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            switch (originalMessage) {
                case "/start":
                    startProcessMessage(chatId, update.getMessage().getChat().getFirstName());
                    break;
                default:
                    sendMessage(chatId, "Sorry command was not recognised"); //TODO make it constant
            }
        }
    }

    private void startProcessMessage(String chatId, String firstName) {
        String answer = String.format("Hi, %s, nice to meet you", firstName);
        sendMessage(chatId, answer);
    }

    public void sendMessage(String chatId, String message) {
        SendMessage response = new SendMessage();
        response.setChatId(chatId);
        response.setText(message);

        try {
            execute(response);
        } catch (TelegramApiException executeException) {
            log.error("Error appeared: " + executeException.getMessage());
        }
    }
}
