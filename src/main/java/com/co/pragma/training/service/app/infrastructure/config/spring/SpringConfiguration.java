package com.co.pragma.training.service.app.infrastructure.config.spring;

import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.usecase.PersonManagementCreateService;
import com.co.pragma.training.service.app.application.usecase.impl.PersonManagementCreateServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class SpringConfiguration {

    @Bean
    public PersonManagementCreateService personManagementCreateService(
            PersonDao personDao) {
        return new PersonManagementCreateServiceImpl(personDao);
    }




}
