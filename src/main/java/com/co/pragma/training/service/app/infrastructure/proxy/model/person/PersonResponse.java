
package com.co.pragma.training.service.app.infrastructure.proxy.model.person;

import lombok.*;

/**
 * <b>Class:</b> PersonResponse.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonResponse {

    private Long id;
    private String names;
    private String lastNames;
    private String sex;
    private Integer age;
    private String cityBirth;
    private String identificationType;
    private String identificationNumber;
    private ImageResponse image;
}