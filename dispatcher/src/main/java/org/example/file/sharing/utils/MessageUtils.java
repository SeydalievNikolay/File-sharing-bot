package org.example.file.sharing.utils;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class MessageUtils {
    public SendMessage generateSendMsgWithText(Update update, String text) {
        var msg = update.getMessage();
        var sendMsg = new SendMessage();
        sendMsg.setChatId(msg.getChatId().toString());
        sendMsg.setText(text);
        return sendMsg;
    }
}
