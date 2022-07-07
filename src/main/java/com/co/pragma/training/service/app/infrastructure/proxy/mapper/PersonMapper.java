package com.co.pragma.training.service.app.infrastructure.proxy.mapper;

import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.domain.Person;
import com.co.pragma.training.service.app.infrastructure.proxy.model.person.PersonRequest;
import com.co.pragma.training.service.app.infrastructure.proxy.model.person.ImageRequest;
import com.co.pragma.training.service.app.infrastructure.proxy.model.person.PersonResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMapper {

    public static PersonRequest mapPersonRequest(Person person) {
        return PersonRequest.builder()
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .age(person.getAge())
                .sex(person.getSex())
                .cityBirth(person.getCityBirth())
                .identificationNumber(person.getIdentificationNumber())
                .identificationType(person.getIdentificationType())
                .image(new ImageRequest(person.getImage().getContent()))
                .build();
    }

    public static Person mapPerson(PersonResponse personResponse) {
        return Person.builder()
                .names(personResponse.getNames())
                .lastNames(personResponse.getLastNames())
                .age(personResponse.getAge())
                .sex(personResponse.getSex())
                .cityBirth(personResponse.getCityBirth())
                .identificationNumber(personResponse.getIdentificationNumber())
                .identificationType(personResponse.getIdentificationType())
                .image(Image.of(
                        personResponse.getImage().getId(),
                        personResponse.getImage().getContent())
                )
                .build();
    }
}
