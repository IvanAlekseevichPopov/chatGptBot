package com.telegram.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.telegram.bot.Entity.User;
import com.telegram.bot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bot implements UpdatesListener {
    private final UserRepository userRepository;
    private final TelegramBot bot;

    @Autowired
    public Bot(
            UserRepository customerRepository
    ) {

        this.userRepository = customerRepository;
        this.bot = new TelegramBot("6542953955:AAFZCmjfz55cCt0CYpZeKmI_-_9dj0W69H4");
    }

    public void start() {


        bot.setUpdatesListener(this);

    }

    @Override
    public int process(List<Update> updates) {
//        @Override
//        public int process(List<Update> updates) {
            updates.forEach(update -> {
                CallbackQuery callbackQuery = update.callbackQuery();
                if (callbackQuery != null) {
                    callbackQuery.chatInstance();
//                            bot.execute(new SendMessage(callbackQuery.message().chat().id(), "test callback"));
                    return;
                }
                long chatId = update.message().chat().id();
                long userId = update.message().from().id();

                User user = this.userRepository.findByExternalId(userId);
                if(user == null) {
                    System.out.println("User not found. Creating: " + userId);
                    user = new User();
                    user.externalId = userId;
                    user.firstName = update.message().from().firstName();
                    user.lastName = update.message().from().lastName();
                    this.userRepository.save(user);
                } else {
                    System.out.println("User found : " + userId);
                }

                System.out.println(chatId);

                SendMessage message = new SendMessage(chatId, "asdfadsf");

                bot.execute(message);
            });

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }
//    }
}
