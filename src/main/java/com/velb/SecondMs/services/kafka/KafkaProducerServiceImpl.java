package com.velb.SecondMs.services.kafka;

import com.velb.SecondMs.model.dto.SaveFirstEntityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private static final String TOPIC = "first-topic";

    @Autowired
    private KafkaTemplate<String, SaveFirstEntityDto> kafkaTemplate;

    public void publishMessage(SaveFirstEntityDto dto) {
        kafkaTemplate.send(TOPIC, dto);
    }
}
