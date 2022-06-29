package com.co.pragma.training.service.app.application.usecase;

import com.co.pragma.training.service.app.domain.Person;

import java.util.List;

/**
 * <b>Interface:</b> PersonManagementSearchOlderAgesService.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

public interface PersonManagementSearchOlderAgesService {

    List<Person> searchOlderAges(Integer age);

}