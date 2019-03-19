package com.example.aartilakkad.libaraymanagement.libaray.Activity;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.RestAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASED_URL="http://192.168.43.23/LM/";
    //public static final String BASED_URL="http://192.168.43.125/LM/";

    public static Retrofit retrofit=null;
    public static RestAdapter restAdapter=null;
    public static Retrofit getclient()
    {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit=new Retrofit.Builder().baseUrl(BASED_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        return retrofit;
    }
    public static RestAdapter addData()
    {
        restAdapter = new RestAdapter.Builder().setEndpoint(BASED_URL).build();
        return restAdapter;
    }
}
