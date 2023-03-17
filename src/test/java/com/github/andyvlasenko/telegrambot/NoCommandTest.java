package com.github.andyvlasenko.telegrambot;

import com.github.andyvlasenko.telegrambot.command.Command;
import com.github.andyvlasenko.telegrambot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.andyvlasenko.telegrambot.command.CommandName.NO;
import static com.github.andyvlasenko.telegrambot.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit test for NoCommand")
public class NoCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendMessageServiceTest);
    }
}
