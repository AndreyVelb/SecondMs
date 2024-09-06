package com.velb.SecondMs.services.secondentity;

import com.velb.SecondMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.SecondMs.controllers.dto.SaveSecondEntityResponse;
import com.velb.SecondMs.model.dto.SecondEntityDto;

import java.util.List;

public interface SecondEntityService {

    SaveSecondEntityResponse save(SaveSecondEntityRequest request);

    List<SecondEntityDto> getAll();
}
