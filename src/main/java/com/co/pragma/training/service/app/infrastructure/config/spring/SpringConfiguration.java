package com.co.pragma.training.service.app.infrastructure.config.spring;

import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.usecase.PersonManagementCreateService;
import com.co.pragma.training.service.app.application.usecase.PersonManagementSearchOlderAgesService;
import com.co.pragma.training.service.app.application.usecase.PersonManagementSearchService;
import com.co.pragma.training.service.app.application.usecase.impl.PersonManagementCreateServiceImpl;
import com.co.pragma.training.service.app.application.usecase.impl.PersonManagementSearchOlderAgesServiceImpl;
import com.co.pragma.training.service.app.application.usecase.impl.PersonManagementSearchServiceImpl;
import com.co.pragma.training.service.app.infrastructure.proxy.config.HeaderApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Lazy
@Configuration
public class SpringConfiguration {

    @Bean
    public PersonManagementCreateService personManagementCreateService(
            PersonDao personDao) {
        return new PersonManagementCreateServiceImpl(personDao);
    }

    @Bean
    public PersonManagementSearchService personManagementSearchService(
            PersonDao personDao) {
        return new PersonManagementSearchServiceImpl(personDao);
    }

    @Bean
    public PersonManagementSearchOlderAgesService personManagementSearchOlderAgesService(
            PersonDao personDao) {
        return new PersonManagementSearchOlderAgesServiceImpl(personDao);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HeaderApplication dataMemory() {
        return new HeaderApplication();
    }

}
