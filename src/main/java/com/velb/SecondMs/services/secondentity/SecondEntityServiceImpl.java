package com.velb.SecondMs.services.secondentity;

import com.velb.SecondMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.SecondMs.controllers.dto.SaveSecondEntityResponse;
import com.velb.SecondMs.model.dto.SecondEntityDto;
import com.velb.SecondMs.model.entity.SecondEntity;
import com.velb.SecondMs.repository.SecondEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SecondEntityServiceImpl implements SecondEntityService {

    private final SecondEntityRepository secondEntityRepository;

    @Override
    @Transactional
    public SaveSecondEntityResponse save(SaveSecondEntityRequest request) {
        var entity = SecondEntity.builder()
                .message(request.getMessage())
                .number(request.getNumber())
                .build();

        var id = secondEntityRepository.save(entity).getId();

        return SaveSecondEntityResponse.builder()
                .id(id)
                .callTime(LocalDateTime.now())
                .build();
    }

    @Override
    public List<SecondEntityDto> getAll() {
        var allEntities = secondEntityRepository.findAll();
        return allEntities.stream()
                .map(entity -> SecondEntityDto.builder()
                        .message(entity.getMessage())
                        .number(entity.getNumber())
                        .build())
                .collect(Collectors.toList());
    }
}
