package com.telegram.bot;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BotBackgroundTask {
    private final Logger logger;
    private final BotRunner botRunner;

    @Autowired
    public BotBackgroundTask(BotRunner botRunner, Logger logger) {
        this.botRunner = botRunner;
        this.logger = logger;
    }


    @Scheduled(initialDelay = 1000)
    public void run() {
        //TODO check that exception in telegramm bot do not crush scheduled task
//        try {
        logger.info("The time is now {}", (new SimpleDateFormat("HH:mm:ss")).format(new Date()));
        botRunner.start();
//        } catch (Throwable e) {
//            log.error("Bot background task caused exception", e);
//        }
    }
}
