package com.velb.SecondMs.services.firstmscall;

import com.velb.SecondMs.controllers.dto.SaveFirstEntityRequest;

public interface FirstMsCallService {

    Long saveInFirstTable(SaveFirstEntityRequest request);
}
