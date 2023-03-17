package com.github.andyvlasenko.telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    void execute(Update update);
    //todo add method unexecute ?
}
