package com.co.pragma.training.service.app.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonManagementUtil {

    private static final String UPLOADED_FOLDER = "C://temp//";
    private static final String EMPTY = "";
    private static final String EXTENSION_JPG = ".jpg";

    public static String convertBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] decodeBase64(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }


    public static String buildFileName(String type, String number) {
        return type.concat("-").concat(number).concat(EXTENSION_JPG);
    }

    public static void downloadFile(byte [] data, File destination) {
        try (var fos = new FileOutputStream(destination)) {
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void validateFile(String type, String number, String imageContent) {
        var file = new File(UPLOADED_FOLDER.concat(buildFileName(type, number)));

        if (!file.isFile()) {
            downloadFile(decodeBase64(imageContent), file);
        }
    }

}
