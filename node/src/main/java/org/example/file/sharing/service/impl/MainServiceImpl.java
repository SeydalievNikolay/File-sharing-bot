package org.example.file.sharing.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.file.sharing.dao.RawDataDAO;
import org.example.file.sharing.service.MainService;
import org.example.file.sharing.service.ProducerService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final RawDataDAO rawDataDAO;
    private final ProducerService producerService;

    @Override
    public void processTextMessage(Update update) {
        saveRawData(update);
    }

    private void saveRawData(Update update) {
    }
}
