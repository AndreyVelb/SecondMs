package com.velb.SecondMs.controllers.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveSecondEntityRequest {

    private String message;
    private int number;
}