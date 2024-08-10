package com.velb.SecondMs.services.kafka;

import com.velb.SecondMs.model.dto.SaveFirstEntityDto;
import com.velb.SecondMs.model.dto.SaveSecondEntityDto;
import com.velb.SecondMs.model.entity.SecondEntity;
import com.velb.SecondMs.repository.SecondEntityRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListenerServiceImpl implements KafkaListenerService {

    private final KafkaProducerService kafkaProducerService;
    private final SecondEntityRepository secondEntityRepository;

    private static final Logger logger = LoggerFactory.getLogger(KafkaListenerServiceImpl.class);

    @KafkaListener(topics = "second-topic", groupId = "group-id",
            properties = {"spring.json.value.default.type=com.velb.SecondMs.model.dto.SaveSecondEntityDto"})
    public void consume(SaveSecondEntityDto dto) {
        logger.info("SAVING SECOND_ENTITY IN DB");
        secondEntityRepository.save(SecondEntity.builder()
                        .message(dto.getMessage())
                        .number(dto.getNumber())
                        .build());

        kafkaProducerService.publishMessage(
                new SaveFirstEntityDto("lastName", "firstname", "+375441313321"));
    }
}
