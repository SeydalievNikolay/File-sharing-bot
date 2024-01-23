package org.example.file.sharing.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.file.sharing.service.ConsumerService;
import org.example.file.sharing.service.MainService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Log4j
@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {
    private final MainService mainService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.text-message-update}")
    public void consumerTextMessageUpdate(Update update) {
        log.debug("Node: Text message is received");
        mainService.processTextMessage(update);
    }

    @Override
    public void consumerDocMessageUpdate(Update update) {

    }

    @Override
    public void consumerPhotoMessageUpdate(Update update) {

    }
}
