package com.andruhovich.geo.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

@Component
public class CityAdvicerBot extends TelegramLongPollingBot {

  @Value("${telegrambot.botUsername}")
  private String botUsername;
  @Value("${telegrambot.botToken}")
  private String botToken;

  @Override
  public String getBotUsername() {
    return botUsername;
  }

  @Override
  public String getBotToken() {
    return botToken;
  }

  @Override
  public void onUpdateReceived(Update update) {
    if (update.getMessage() != null && update.getMessage().hasText()) {
      Long chat_id = update.getMessage().getChatId();
      try {
        execute(new SendMessage(chat_id.toString(), "Hi " + update.getMessage().getText()));
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }

  @PostConstruct
  public void botConnect() {
    TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
    try {
      telegramBotsApi.registerBot(this);
    } catch (TelegramApiException e) {
      e.printStackTrace();
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e1) {
        e1.printStackTrace();
        return;
      }
      botConnect();
    }
  }

  public void setBotUsername(String botUsername) {
    this.botUsername = botUsername;
  }

  public void setBotToken(String botToken) {
    this.botToken = botToken;
  }

  @Override
  public String toString() {
    return "CityAdvicerBot{" +
        "botUsername='" + botUsername + '\'' +
        ", botToken='" + botToken + '\'' +
        '}';
  }
}
