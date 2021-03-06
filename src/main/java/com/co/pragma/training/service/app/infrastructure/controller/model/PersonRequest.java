
package com.co.pragma.training.service.app.infrastructure.controller.model;

import lombok.Data;

/**
 * <b>Class:</b> PersonRequest.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@Data
public class PersonRequest {

    private String names;
    private String lastNames;
    private String sex;
    private Integer age;
    private String cityBirth;
    private String identificationType;
    private String identificationNumber;

}
