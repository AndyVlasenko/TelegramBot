package com.github.andyvlasenko.telegrambot.command;

import com.github.andyvlasenko.telegrambot.services.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {
    public final static String START_MESSAGE = "Zdravo ";
    private final SendMessageService sendMessageService;

    public StartCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
