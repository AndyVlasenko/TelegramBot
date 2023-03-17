package com.github.andyvlasenko.telegrambot;

import com.github.andyvlasenko.telegrambot.bot.TelegramBot;
import com.github.andyvlasenko.telegrambot.services.SendMessageService;
import com.github.andyvlasenko.telegrambot.services.impl.SendMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit test for SendMessageService")
public class SendMessageServiceTest {
    private SendMessageService sendMessageServiceTest;
    private TelegramBot telegramBotTest;

    @BeforeEach
    public void init(){
        telegramBotTest = Mockito.mock(TelegramBot.class);
        sendMessageServiceTest = new SendMessageServiceImpl(telegramBotTest);
    }

    @Test
    public void shouldSendMessage() throws TelegramApiException {
        String chatIdTest = "chat_id_test";
        String messageTest = "message_test";

        //given
        SendMessage sendMessageTest = new SendMessage();
        sendMessageTest.setChatId(chatIdTest);
        sendMessageTest.setText(messageTest);
        sendMessageTest.enableHtml(true);

        //when
        sendMessageServiceTest.sendMessage(chatIdTest, messageTest);
        //then
        Mockito.verify(telegramBotTest).execute(sendMessageTest);
    }
}
