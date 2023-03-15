package com.github.andyvlasenko.telegrambot.services;

import com.github.andyvlasenko.telegrambot.TelegramBotApplication;
import com.github.andyvlasenko.telegrambot.config.BotConfig;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//TODO Move to WebHook
@Component
@Log4j2
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

            SendMessage response = new SendMessage();
            response.setChatId(chatId);
            response.setText(String.format("You sent: %s", originalMessage));
            sendAnswerMessage(response);
        }
    }

    public void sendAnswerMessage (SendMessage message) {
        if(message != null) {
            try {
                execute(message);
                //TODO remove sout and log
                System.out.println(message.getText());
                log.debug(message.getText());
            } catch (TelegramApiException telegramApiException) {
                log.error(telegramApiException);
            }
        }
    }
}
