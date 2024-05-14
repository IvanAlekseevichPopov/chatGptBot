package com.telegram.bot;

import com.pengrad.telegrambot.TelegramBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private final String botToken;

    @Autowired
    public AppConfig(
            @Value("#{environment.BOT_TOKEN}")
            String botToken
    ) {
        this.botToken = botToken;
    }

    @Bean
    public Logger getLogger() {
        return LoggerFactory.getLogger(BotBackgroundTask.class);
    }

    @Bean
    public TelegramBot getTgBot() {
        return new TelegramBot(botToken);
    }
}
