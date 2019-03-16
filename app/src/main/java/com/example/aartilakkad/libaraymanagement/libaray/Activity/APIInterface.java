package com.example.aartilakkad.libaraymanagement.libaray.Activity;

import com.example.aartilakkad.libaraymanagement.libaray.Activity.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {
    @FormUrlEncoded
    @POST("loginControllerJson.php")
    Call<LoginResponse> checkLogin(
            @Field("Mobile") String Mobile,
            @Field("Password") String Password,
            @Field("Login") String Login
    );
}
