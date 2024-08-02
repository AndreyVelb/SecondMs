package com.velb.SecondMs.services.kafka;

import com.velb.SecondMs.model.dto.SaveFirstEntityDto;
import com.velb.SecondMs.model.dto.SaveSecondEntityDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListenerServiceImpl implements KafkaListenerService {

    private final KafkaProducerService kafkaProducerService;
    private static final Logger logger = LoggerFactory.getLogger(KafkaListenerServiceImpl.class);

    @KafkaListener(topics = "second-topic", groupId = "group-id")
    public void consume(SaveSecondEntityDto dto) {
        logger.info("DTO RECEIVED FROM KAFKA: " + dto.getMessage() + " " + dto.getNumber());

        kafkaProducerService.publishMessage(
                SaveFirstEntityDto.builder()
                        .lastName("lastName")
                        .firstName("firstname")
                        .phoneNumber("+375441313321")
                        .build());
    }
}
