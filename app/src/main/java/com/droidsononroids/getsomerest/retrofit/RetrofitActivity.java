package com.droidsononroids.getsomerest.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.droidsononroids.getsomerest.R;
import com.droidsononroids.getsomerest.model.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final RetrofitService retrofitService = retrofit.create(RetrofitService.class);


        final Call<UserResponse> userCall = retrofitService.getUsers(10);
        userCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(final Call<UserResponse> call, final Response<UserResponse> response) {
                final UserResponse userResponse = response.body();
                Log.d("Retrofit", userResponse.toString());
            }

            @Override
            public void onFailure(final Call<UserResponse> call, final Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
