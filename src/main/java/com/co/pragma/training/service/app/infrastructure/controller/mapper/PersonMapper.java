package com.co.pragma.training.service.app.infrastructure.controller.mapper;

import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.domain.Person;
import com.co.pragma.training.service.app.infrastructure.controller.model.PersonRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Base64;

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

    private static String convertBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    private static byte[] decodeBase64(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

}
