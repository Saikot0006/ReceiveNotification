package com.example.pushnotification;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInstance {

    @POST("device-token-verify")
    Call<TokenModel> getData(@Body JsonObject jsonObject);
}
