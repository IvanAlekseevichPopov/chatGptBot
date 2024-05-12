package com.telegram.bot;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BotBackgroundTask {
    private final Logger log;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final Bot bot;

    @Autowired
    public BotBackgroundTask(
            Bot bot,
            Logger logger
    ){
        this.bot = bot;
        this.log = logger;
    }

    @Scheduled(initialDelay = 1000 )
    public void run() {
//        try {
            log.info("The time is now {}", dateFormat.format(new Date()));
            bot.start();
//        } catch (Throwable e) {
//            log.error("Bot background task caused exception", e);
//        }
    }
}