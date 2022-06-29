package com.co.pragma.training.service.app.application.dao;

import com.co.pragma.training.service.app.domain.Person;

import java.util.List;

public interface PersonDao {

    void save(Person person);

    Person getPerson(String documentType, String documentNumber);

    List<Person> getPeopleByAgeOlder(Integer age);
}
