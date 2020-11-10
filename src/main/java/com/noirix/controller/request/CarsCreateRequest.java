package com.noirix.controller.request;

import lombok.Data;

@Data
public class CarsCreateRequest {

    private String model;

    private Integer creationYear;

    private Long userId;

    private Double price;

    private String color;
}
