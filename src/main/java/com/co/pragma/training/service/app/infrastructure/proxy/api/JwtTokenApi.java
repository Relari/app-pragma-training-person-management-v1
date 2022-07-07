package com.co.pragma.training.service.app.infrastructure.proxy.api;

import com.co.pragma.training.service.app.infrastructure.proxy.model.jwt.JwtResponse;
import com.co.pragma.training.service.app.infrastructure.proxy.model.jwt.LoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JwtTokenApi {

    @POST("token/generate")
    Call<JwtResponse> generate(
            @Body LoginRequest loginRequest,
            @Query("additionalParameters") boolean additionalParameters
    );

}
