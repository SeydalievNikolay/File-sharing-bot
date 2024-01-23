package org.example.file.sharing.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.file.sharing.utils.MessageUtils;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@RequiredArgsConstructor
@Component
public class UpdateProcessor {
    private TelegramBot telegramBot;
    private final MessageUtils messageUtils;

    public void registerBot(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void processUpdate(Update update) {
        if (update == null) {
            log.error("Received update is null");
            return;
        }
        if (update.hasMessage()) {
            distributeMessagesByType(update);
        } else {
            log.error("Unsupported message type is received: " + update);
        }
    }

    private void distributeMessagesByType(Update update) {
        var msg = update.getMessage();
        if (msg.hasText()) {
            processTextMessage(update);
        } else if (msg.hasDocument()) {
            processDocMessage(update);
        } else if (msg.hasPhoto()) {
            processPhotoMessage(update);
        } else {
            setUnsupportedMessageTypeView(update);
        }
    }

    private void setUnsupportedMessageTypeView(Update update) {
        var sendMessage = messageUtils.generateSendMsgWithText(update,
                "Неподдерживаемый тип сообщения!");
        setView(sendMessage);
    }

    private void processPhotoMessage(Update update) {

    }

    private void processDocMessage(Update update) {
    }

    private void processTextMessage(Update update) {
    }

    public void setView(SendMessage sendMessage) {
        telegramBot.sendAnswerMessage(sendMessage);
    }
}
