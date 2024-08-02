package com.velb.SecondMs.services.kafka;

import com.velb.SecondMs.model.dto.SaveFirstEntityDto;

public interface KafkaProducerService {

    void publishMessage(SaveFirstEntityDto dto);
}
