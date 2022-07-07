package com.co.pragma.training.service.app.infrastructure.proxy;

import com.co.pragma.training.service.app.infrastructure.proxy.config.HeaderApplication;
import com.co.pragma.training.service.app.infrastructure.proxy.api.JwtTokenApi;
import com.co.pragma.training.service.app.infrastructure.proxy.model.jwt.JwtResponse;
import com.co.pragma.training.service.app.infrastructure.proxy.model.jwt.LoginRequest;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

/**
 * <b>Class:</b> LoginService.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Slf4j
@Component
@AllArgsConstructor
public class LoginService implements UserDetailsService {

  private final JwtTokenApi jwtTokenApi;
  private final HeaderApplication headerApplication;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    JwtResponse jwtResponse = null;

    try {
      jwtResponse = jwtTokenApi.generate(new LoginRequest(username, username), true)
              .execute()
              .body();
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }

    assert jwtResponse != null;

    headerApplication.setTokenType(jwtResponse.getTokenType());
    headerApplication.setAccessToken(jwtResponse.getAccessToken());
    headerApplication.setExpiresIn(jwtResponse.getExpiresIn());
    headerApplication.setIssuedAt(jwtResponse.getIssuedAt());
    headerApplication.setUsername(jwtResponse.getProfile().getUsername());
    headerApplication.setPassword(jwtResponse.getProfile().getPassword());

    return new User(
            jwtResponse.getProfile().getUsername(),
            jwtResponse.getProfile().getPassword(),
            Collections.emptyList()
    );

  }

}
