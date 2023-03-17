package com.github.andyvlasenko.telegrambot;

import com.github.andyvlasenko.telegrambot.command.Command;
import com.github.andyvlasenko.telegrambot.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.andyvlasenko.telegrambot.command.CommandName.START;
import static com.github.andyvlasenko.telegrambot.command.StartCommand.START_MESSAGE;

@DisplayName("Unit test for StartCommand")
public class StartCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendMessageServiceTest);
    }
}
