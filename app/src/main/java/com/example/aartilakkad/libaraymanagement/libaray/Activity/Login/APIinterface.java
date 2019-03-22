package com.example.aartilakkad.libaraymanagement.libaray.Activity.Login;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit2.Call;

public interface APIinterface {
    @FormUrlEncoded
    @POST("MCA_demo.php")
    Call<FeedbackResponse> CheckFeedback(
            @Field("email") String email,
            @Field("comment") String password,
            @Field("Feedback") String Login
    );
}
