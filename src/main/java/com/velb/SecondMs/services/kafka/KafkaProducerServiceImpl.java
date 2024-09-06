package com.velb.SecondMs.services.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.velb.SecondMs.model.dto.SaveFirstEntityDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired
    private Producer<String,String> producer;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    @Value(value = "${cluster.kafka.topic.first-topic}")
    private String firstTopic;

    @Override
    public void publishMessage(SaveFirstEntityDto dto) throws JsonProcessingException {
        logger.info("SECOND_MS PUBLISHING IN FIRST_TOPIC");

        ObjectMapper objectMapper = new ObjectMapper();

        producer.send(new ProducerRecord<>(firstTopic, objectMapper.writeValueAsString(dto)));
    }
}
