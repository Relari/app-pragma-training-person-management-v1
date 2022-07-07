package com.co.pragma.training.service.app.infrastructure.proxy.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class HeaderApplication {

    private String tokenType;
    private String accessToken;
    private String expiresIn;
    private String issuedAt;
    private String username;
    private String password;

    public String buildBearerToken() {
        return tokenType.concat(" ").concat(accessToken);
    }

}
