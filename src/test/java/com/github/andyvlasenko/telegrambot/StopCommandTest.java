package com.github.andyvlasenko.telegrambot;

import com.github.andyvlasenko.telegrambot.command.Command;
import com.github.andyvlasenko.telegrambot.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.andyvlasenko.telegrambot.command.CommandName.STOP;
import static com.github.andyvlasenko.telegrambot.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit test for StopCommand")
public class StopCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendMessageServiceTest);
    }
}
