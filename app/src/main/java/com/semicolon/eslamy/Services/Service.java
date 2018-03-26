package com.semicolon.eslamy.Services;

import com.semicolon.eslamy.Models.LangModel;
import com.semicolon.eslamy.Models.OthersModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Delta on 25/03/2018.
 */

public interface Service {

    @GET("api/languages")
    Call<List<LangModel>>DisplayLanguage();

    @FormUrlEncoded
    @POST("api/getLanguage")
    Call<List<OthersModel>>DisplayOthersData(@Field("id") String id,@Field("type")String type);
}
