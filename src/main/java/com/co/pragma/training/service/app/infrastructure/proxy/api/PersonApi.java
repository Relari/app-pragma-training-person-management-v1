package com.co.pragma.training.service.app.infrastructure.proxy.api;

import com.co.pragma.training.service.app.infrastructure.proxy.model.PersonRequest;
import com.co.pragma.training.service.app.infrastructure.proxy.model.PersonResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface PersonApi {

  @GET("people")
  Call<PersonResponse> findPersonByDocument(
          @QueryMap Map<String, String> queryParams
  );

  @GET("people/{age}/older")
  Call<List<PersonResponse>> getPeopleByAgeOlder(
          @Path("age") Integer age
  );

  @POST("people")
  Call<Void> save(
          @Body PersonRequest employeeEntity
  );

}
