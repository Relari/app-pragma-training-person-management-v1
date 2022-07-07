package com.co.pragma.training.service.app.infrastructure.proxy.model.jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046815L;

    private String username;
    private String password;
}
