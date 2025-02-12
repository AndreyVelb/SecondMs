package com.velb.SecondMs.controllers;

import com.velb.SecondMs.controllers.dto.SaveFirstEntityRequest;
import com.velb.SecondMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.SecondMs.controllers.dto.SaveSecondEntityResponse;
import com.velb.SecondMs.model.dto.SecondEntityDto;
import com.velb.SecondMs.services.firstmscall.FirstMsCallService;
import com.velb.SecondMs.services.secondentity.SecondEntityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/second")
@RequiredArgsConstructor
public class SecondMsController {

    private final FirstMsCallService firstMsCallService;
    private final SecondEntityService secondEntityService;
    private static final Logger logger = LoggerFactory.getLogger(SecondMsController.class);

    @PostMapping("/call-first")
    @ResponseStatus(HttpStatus.CREATED)
    public Long get(@RequestBody SaveFirstEntityRequest request) {
        logger.info("Second ms call first ms");
        return firstMsCallService.saveInFirstTable(request);
    }

    @PostMapping("/entities")
    @ResponseStatus(HttpStatus.CREATED)
    public SaveSecondEntityResponse saveEntity(@RequestBody SaveSecondEntityRequest request) {
        logger.info("Second ms was called");
        return secondEntityService.save(request);
    }

    @GetMapping("/entities")
    @ResponseStatus(HttpStatus.OK)
    public List<SecondEntityDto> getAllEntities() {
        logger.info("Get all entities");
        return secondEntityService.getAll();
    }
}
