package com.velb.SecondMs.services.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.velb.SecondMs.model.dto.SaveFirstEntityDto;

public interface KafkaProducerService {

    void publishMessage(SaveFirstEntityDto dto) throws JsonProcessingException;
}
