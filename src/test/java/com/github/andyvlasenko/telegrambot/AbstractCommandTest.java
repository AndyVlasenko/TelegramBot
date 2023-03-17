package com.github.andyvlasenko.telegrambot;

import com.github.andyvlasenko.telegrambot.bot.TelegramBot;
import com.github.andyvlasenko.telegrambot.command.Command;
import com.github.andyvlasenko.telegrambot.services.SendMessageService;
import com.github.andyvlasenko.telegrambot.services.impl.SendMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstractCommandTest {
    protected TelegramBot telegramBotTest = Mockito.mock(TelegramBot.class);
    protected SendMessageService sendMessageServiceTest = new SendMessageServiceImpl(telegramBotTest);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldExecuteCommand() throws TelegramApiException {
        String chatIdTest = "12123123123";

        Update updateTest = new Update();
        Message messageTest = Mockito.mock(Message.class);
        Mockito.when(messageTest.getChatId()).thenReturn(Long.valueOf(chatIdTest));
        Mockito.when(messageTest.getText()).thenReturn(getCommandName());
        updateTest.setMessage(messageTest);

        SendMessage sendMessageTest = new SendMessage();
        sendMessageTest.setChatId(chatIdTest);
        sendMessageTest.setText(getCommandMessage());
        sendMessageTest.enableHtml(true);

        //when
        getCommand().execute(updateTest);
        //then
        Mockito.verify(telegramBotTest).execute(sendMessageTest);
    }
}
