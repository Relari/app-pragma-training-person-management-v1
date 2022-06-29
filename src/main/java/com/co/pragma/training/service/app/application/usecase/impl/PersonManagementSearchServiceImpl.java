package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.usecase.PersonManagementSearchService;
import com.co.pragma.training.service.app.domain.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class PersonManagementSearchServiceImpl implements PersonManagementSearchService {

    private PersonDao personDao;

    @Override
    public Person getPerson(String documentType, String documentNumber) {
        return personDao.getPerson(documentType, documentNumber);
    }

}
