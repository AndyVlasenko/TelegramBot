package com.github.andyvlasenko.telegrambot.services;


public interface SendMessageService {
    void sendMessage(String chatId, String message);
}
