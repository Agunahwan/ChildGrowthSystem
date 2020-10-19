package com.agunahwanabsin.childgrowthsystem.api.instance;

import com.agunahwanabsin.childgrowthsystem.api.model.response.Growth;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GrowthInterface {
    @Headers("Content-Type: application/json")
    @GET("list")
    Call<List<Growth>> getList();

    @Headers("Content-Type: application/json")
    @POST("save")
    Call<Boolean> save(@Body com.agunahwanabsin.childgrowthsystem.api.model.request.Growth body);

    @GET("delete")
    Call<ResponseBody> delete(@Path("tanggalCatat") String tanggalCatat);
}
