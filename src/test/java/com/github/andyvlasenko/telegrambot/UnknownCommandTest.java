package com.github.andyvlasenko.telegrambot;

import com.github.andyvlasenko.telegrambot.command.Command;
import com.github.andyvlasenko.telegrambot.command.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.andyvlasenko.telegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendMessageServiceTest);
    }
}