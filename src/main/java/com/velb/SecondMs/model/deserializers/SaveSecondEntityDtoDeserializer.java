package com.velb.SecondMs.model.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velb.SecondMs.model.dto.SaveSecondEntityDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SaveSecondEntityDtoDeserializer implements Deserializer<SaveSecondEntityDto> {

//    @Autowired
//    private final ObjectMapper objectMapper;

    @Override
    public SaveSecondEntityDto deserialize(String s, byte[] bytes) {
        var objectMapper = new ObjectMapper();
        try {
            if (bytes == null){
                return null;
            }
            return objectMapper.readValue(new String(bytes), SaveSecondEntityDto.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to SaveSecondEntityDto");
        }
    }
}
