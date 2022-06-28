package com.co.pragma.training.service.app.application.usecase;

import com.co.pragma.training.service.app.domain.Person;

public interface PersonManagementSearchService {

    Person getPerson(String documentType, String documentNumber);

}
