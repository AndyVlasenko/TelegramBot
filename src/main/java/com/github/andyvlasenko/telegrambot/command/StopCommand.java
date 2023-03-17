package com.github.andyvlasenko.telegrambot.command;

import com.github.andyvlasenko.telegrambot.services.SendMessageService;
import com.github.andyvlasenko.telegrambot.services.impl.SendMessageServiceImpl;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}.
 */
public class StopCommand implements Command {
    public static final String STOP_MESSAGE = "Деактивировал CHAO \uD83D\uDE1F.";
    private final SendMessageService sendMessageService;

    public StopCommand(SendMessageService sendBotMessageService) {
        this.sendMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}