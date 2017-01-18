package com.droidsononroids.getsomerest.retrofit;

import com.droidsononroids.getsomerest.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("api")
    public Call<UserResponse> getUser();

    @GET("api")
    public Call<UserResponse> getUsers(@Query("results") int count);
}
