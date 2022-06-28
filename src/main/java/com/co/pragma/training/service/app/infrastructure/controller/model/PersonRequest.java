
package com.co.pragma.training.service.app.infrastructure.controller.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonRequest implements Serializable {

    private String names;
    private String lastNames;
    private String sex;
    private Integer age;
    private String cityBirth;
    private String identificationType;
    private String identificationNumber;

}
