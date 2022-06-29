package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.usecase.PersonManagementSearchOlderAgesService;
import com.co.pragma.training.service.app.domain.Person;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * <b>Class:</b> PersonManagementSearchOlderAgesServiceImpl.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@AllArgsConstructor
public class PersonManagementSearchOlderAgesServiceImpl implements PersonManagementSearchOlderAgesService {

    private final PersonDao personDao;

    @Override
    public List<Person> searchOlderAges(Integer age) {
        return personDao.getPeopleByAgeOlder(age);
    }

}
