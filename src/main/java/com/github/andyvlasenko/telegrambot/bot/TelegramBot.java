package com.github.andyvlasenko.telegrambot.bot;

import com.github.andyvlasenko.telegrambot.command.CommandContainer;
import com.github.andyvlasenko.telegrambot.config.BotConfig;
import com.github.andyvlasenko.telegrambot.services.impl.SendMessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.github.andyvlasenko.telegrambot.command.CommandName.NO;

//TODO Move to WebHook
@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";
    final BotConfig botConfig;

    final CommandContainer commandContainer;

    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
        this.commandContainer = new CommandContainer(new SendMessageServiceImpl(this));
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

            if (originalMessage.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = originalMessage.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }
}
