package com.velb.SecondMs.services.secondentity;

import com.velb.SecondMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.SecondMs.controllers.dto.SaveSecondEntityResponse;

public interface SecondEntityService {

    SaveSecondEntityResponse save(SaveSecondEntityRequest request);
}
