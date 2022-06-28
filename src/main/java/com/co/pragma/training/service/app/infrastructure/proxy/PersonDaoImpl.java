package com.co.pragma.training.service.app.infrastructure.proxy;

import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.domain.Person;
import com.co.pragma.training.service.app.infrastructure.proxy.api.PersonApi;
import com.co.pragma.training.service.app.infrastructure.proxy.mapper.PersonMapper;
import com.co.pragma.training.service.app.infrastructure.proxy.model.PersonResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class PersonDaoImpl implements PersonDao {

    private final PersonApi personApi;

    @Override
    public void save(Person person) {

        var personRequest = PersonMapper.mapPersonRequest(person);

        try {

            var isProcess = personApi.save(personRequest)
                    .execute()
                    .isSuccessful();

            if (isProcess) {
                log.info(person.toString());
            }

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public Person getPerson(String documentType, String documentNumber) {

        Map<String, String> queryParams = Map.of(
                "documentType", documentType,
                "documentNumber", documentNumber
        );

        PersonResponse personResponse = null;

        try {

            personResponse = personApi.findAll(queryParams)
                    .execute()
                    .body();

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        assert personResponse != null;
        return PersonMapper.mapPerson(personResponse);
    }


}
