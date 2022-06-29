package com.co.pragma.training.service.app.infrastructure.controller.mapper;

import static com.co.pragma.training.service.app.util.PersonManagementUtil.convertBase64;

import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.domain.Person;
import com.co.pragma.training.service.app.infrastructure.controller.model.ImageResponse;
import com.co.pragma.training.service.app.infrastructure.controller.model.PersonRequest;
import com.co.pragma.training.service.app.infrastructure.controller.model.PersonResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMapper {

    private static final String EMPTY = "";

    public static Person mapPerson(
            PersonRequest personRequest, byte[] imageContentInBytes) {

        return Person.builder()
                .names(personRequest.getNames())
                .lastNames(personRequest.getLastNames())
                .age(personRequest.getAge())
                .cityBirth(personRequest.getCityBirth())
                .identificationNumber(personRequest.getIdentificationNumber())
                .identificationType(personRequest.getIdentificationType())
                .image(Image.of(EMPTY, convertBase64(imageContentInBytes)))
                .sex(personRequest.getSex())
                .build();
    }

    public static PersonResponse mapPersonResponse(Person person) {
        return PersonResponse.builder()
                .id(person.getId())
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .sex(person.getSex())
                .age(person.getAge())
                .cityBirth(person.getCityBirth())
                .identificationType(person.getIdentificationType())
                .identificationNumber(person.getIdentificationNumber())
                .image(new ImageResponse(
                        person.getImage().getId(),
                        person.getImage().getContent())
                )
                .build();
    }

}
