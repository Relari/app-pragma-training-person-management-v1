package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.usecase.PersonManagementCreateService;
import com.co.pragma.training.service.app.application.usecase.PersonManagementSearchService;
import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.domain.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Slf4j
@AllArgsConstructor
public class PersonManagementSearchServiceImpl implements PersonManagementSearchService {

    private PersonDao personDao;

    @Override
    public Person getPerson(String documentType, String documentNumber) {

        var person = personDao.getPerson("DNI", "70605398");

        var fileRoute = person.getIdentificationType()
                .concat("-")
                .concat(person.getIdentificationNumber())
                .concat(".jpg");

        var file = new File(fileRoute);

        if (!file.isFile()) {
            downloadFile(
                    decodeBase64(person.getImage().getContent()), file
            );
        }

        return person.mutate()
                .image(Image.of("", fileRoute))
                .build();
    }

    private static byte[] decodeBase64(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

    public static void downloadFile(byte [] data, File destination) {

        try (var fos = new FileOutputStream(destination)) {
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
