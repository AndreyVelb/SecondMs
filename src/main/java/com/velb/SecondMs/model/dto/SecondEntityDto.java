package com.velb.SecondMs.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecondEntityDto {

    private String message;
    private int number;
}
