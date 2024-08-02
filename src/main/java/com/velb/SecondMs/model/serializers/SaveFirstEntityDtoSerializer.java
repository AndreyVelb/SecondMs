package com.velb.SecondMs.model.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velb.SecondMs.model.dto.SaveFirstEntityDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SaveFirstEntityDtoSerializer implements Serializer<SaveFirstEntityDto> {

//    @Autowired
//    private final ObjectMapper objectMapper;

    @Override
    public byte[] serialize(String s, SaveFirstEntityDto dto) {
        var objectMapper = new ObjectMapper();
        try {
            if (dto == null){
                return null;
            }
            return objectMapper.writeValueAsBytes(dto);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing SaveFirstEntityDto to byte[]");
        }
    }
}
