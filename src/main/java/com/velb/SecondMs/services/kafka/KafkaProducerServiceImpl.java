package com.velb.SecondMs.services.kafka;

import com.velb.SecondMs.model.dto.SaveFirstEntityDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, SaveFirstEntityDto> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    @Value(value = "${cluster.kafka.topic.first-topic}")
    private String firstTopic;

    public void publishMessage(SaveFirstEntityDto dto) {
        logger.info("SECOND_MS PUBLISHING IN FIRST_TOPIC");
        kafkaTemplate.send(firstTopic, dto);
    }
}
