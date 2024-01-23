package org.example.file.sharing.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.file.sharing.controller.UpdateProcessor;
import org.example.file.sharing.service.AnswerConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
@Service
@RequiredArgsConstructor

public class AnswerConsumerImpl implements AnswerConsumer {
    private final UpdateProcessor updateProcessor;
    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.answer-message}")
    public void consume(SendMessage sendMessage) {
        updateProcessor.setView(sendMessage);
    }
}
