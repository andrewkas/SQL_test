package com.noirix.controller.request;

import com.noirix.domain.Cars;
import lombok.Data;

@Data
public class SearchAtribute {
    private Cars entity;

    private String query;

    private Long limit;
}
