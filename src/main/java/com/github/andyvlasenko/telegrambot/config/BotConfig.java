package com.github.andyvlasenko.telegrambot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
//@PropertySource("application.properties")
public class BotConfig {
    //@Value("${bot.name}")
    String botName = System.getenv("BOT_NAME");
    //@Value("${bot.token}")
    String botToken = System.getenv("BOT_TOKEN");
}
