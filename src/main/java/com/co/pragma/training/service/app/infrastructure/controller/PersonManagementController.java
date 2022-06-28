package com.co.pragma.training.service.app.infrastructure.controller;

import com.co.pragma.training.service.app.application.usecase.PersonManagementCreateService;
import com.co.pragma.training.service.app.infrastructure.controller.mapper.PersonMapper;
import com.co.pragma.training.service.app.infrastructure.controller.model.PersonRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Slf4j
@Controller
@AllArgsConstructor
public class PersonManagementController {

    private final PersonManagementCreateService personManagementCreateService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("person", new PersonRequest());

        return "index";
    }

    @PostMapping(path = "/register")
    public String register(
            @ModelAttribute("person") PersonRequest data,
            @RequestParam("file") MultipartFile file) throws IOException {

        var person = PersonMapper.mapPerson(data, file.getBytes());

        personManagementCreateService.savePerson(person);

        return "index";
    }

}
