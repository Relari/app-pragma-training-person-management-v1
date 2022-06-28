package com.co.pragma.training.service.app.infrastructure.proxy.api;

import com.co.pragma.training.service.app.infrastructure.proxy.model.PersonRequest;
import com.co.pragma.training.service.app.infrastructure.proxy.model.PersonResponse;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface PersonApi {

  @GET("people")
  Call<PersonResponse> findAll(
          @QueryMap Map<String, String> queryParams
  );

  @POST("people")
  Call<Void> save(
          @Body PersonRequest employeeEntity
  );

}
