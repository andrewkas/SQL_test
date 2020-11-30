package com.noirix.controller.request;

import lombok.Data;

@Data
public class CarsChangeRequest extends CarsCreateRequest {
    private Long id;
}
