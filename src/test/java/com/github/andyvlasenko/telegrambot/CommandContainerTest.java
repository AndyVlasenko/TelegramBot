package com.github.andyvlasenko.telegrambot;

import com.github.andyvlasenko.telegrambot.command.Command;
import com.github.andyvlasenko.telegrambot.command.CommandContainer;
import com.github.andyvlasenko.telegrambot.command.CommandName;
import com.github.andyvlasenko.telegrambot.command.UnknownCommand;
import com.github.andyvlasenko.telegrambot.services.SendMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit test for CommandContainer")
public class CommandContainerTest {
    private CommandContainer commandContainerTest;

    @BeforeEach
    public void init() {
        SendMessageService sendMessageServiceTest = Mockito.mock(SendMessageService.class);
        commandContainerTest = new CommandContainer(sendMessageServiceTest);
    }

    @Test
    public void shouldGetAllCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainerTest.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command);
                });
    }

    @Test
    public void shouldReturnUnknownCommands() {
        String unknownStringTest = "sadasdasdasd";

        Command unknownCommandTest = commandContainerTest.retrieveCommand(unknownStringTest);

        Assertions.assertEquals(UnknownCommand.class, unknownCommandTest.getClass());
    }
}
