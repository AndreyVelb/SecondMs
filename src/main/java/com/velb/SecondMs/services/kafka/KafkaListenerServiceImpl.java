package com.velb.SecondMs.services.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListenerServiceImpl implements KafkaListenerService {

    private final KafkaProducerService kafkaProducerService;

    @KafkaListener(topics = "second-topic", groupId = "group-id")
    public void consume(String message) {
        kafkaProducerService.publishMessage(message);
    }
}
