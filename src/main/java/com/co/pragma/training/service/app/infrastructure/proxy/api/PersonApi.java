package com.co.pragma.training.service.app.infrastructure.proxy.api;

import com.co.pragma.training.service.app.infrastructure.proxy.model.person.PersonRequest;
import com.co.pragma.training.service.app.infrastructure.proxy.model.person.PersonResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.*;

public interface PersonApi {

  @GET("people")
  Call<PersonResponse> findPersonByDocument(
          @Header("Authorization") String authorization,
          @QueryMap Map<String, String> queryParams
  );

  @GET("people/{age}/older")
  Call<List<PersonResponse>> getPeopleByAgeOlder(
          @Header("Authorization") String authorization,
          @Path("age") Integer age
  );

  @POST("people")
  Call<Void> save(
          @Header("Authorization") String authorization,
          @Body PersonRequest employeeEntity
  );

}
