package com.co.pragma.training.service.app.infrastructure.controller;

import com.co.pragma.training.service.app.application.usecase.PersonManagementCreateService;
import com.co.pragma.training.service.app.application.usecase.PersonManagementSearchOlderAgesService;
import com.co.pragma.training.service.app.application.usecase.PersonManagementSearchService;
import com.co.pragma.training.service.app.infrastructure.controller.mapper.PersonMapper;
import com.co.pragma.training.service.app.infrastructure.controller.model.PersonRequest;
import com.co.pragma.training.service.app.infrastructure.controller.model.PersonResponse;
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
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@AllArgsConstructor
public class PersonManagementController {

    private final PersonManagementCreateService personManagementCreateService;
    private final PersonManagementSearchService personManagementSearchService;

    private final PersonManagementSearchOlderAgesService personManagementSearchOlderAgesService;

    @GetMapping({"/", "/login"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "redirect:/login?logout";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {

        model.addAttribute("person", new PersonRequest());

        return "register";
    }

    @PostMapping(path = "/register")
    public String register(
            @ModelAttribute("person") PersonRequest data,
            @RequestParam("file") MultipartFile file) throws IOException {

        var person = PersonMapper.mapPerson(data, file.getBytes());

        personManagementCreateService.savePerson(person);

        return "redirect:/information?documentType="
                .concat(person.getIdentificationType())
                .concat("&documentNumber=")
                .concat(person.getIdentificationNumber());
    }

    @GetMapping("/information")
    public String showInformation(
            @RequestParam("documentType") String documentType,
            @RequestParam("documentNumber") String documentNumber,
            Model model) {

        var person = personManagementSearchService.getPerson(documentType, documentNumber);

        var personResponse = PersonMapper.mapPersonResponse(person);

        model.addAttribute("person", personResponse);

        return "information";
    }

    @GetMapping("/people")
    public String people(
            Model model) {

        List<PersonResponse> people = personManagementSearchOlderAgesService.searchOlderAges(0)
                .stream()
                .map(PersonMapper::mapPersonResponse)
                .collect(Collectors.toList());

        model.addAttribute("people", people);

        return "people";
    }
}
