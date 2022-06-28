package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.usecase.PersonManagementCreateService;
import com.co.pragma.training.service.app.domain.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class PersonManagementCreateServiceImpl implements PersonManagementCreateService {

    private PersonDao personDao;

    @Override
    public void savePerson(Person person) {
        personDao.save(person);
    }

}
