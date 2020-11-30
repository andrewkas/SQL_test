package com.noirix.controller.request;

import com.noirix.domain.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class UserCreateRequest {
    private String name;

    private String surname;

    private Date birthDate;

    private String login;

    private String password;

    private Gender gender = Gender.NOT_SELECTED;

    private Float weight;
}
