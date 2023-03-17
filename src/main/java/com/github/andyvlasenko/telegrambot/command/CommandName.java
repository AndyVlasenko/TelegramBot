package com.github.andyvlasenko.telegrambot.command;

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("/");
    private final String commandName;

    public String getCommandName() {
        return commandName;
    }

    CommandName(String commandName) {
        this.commandName = commandName;
    }
}
