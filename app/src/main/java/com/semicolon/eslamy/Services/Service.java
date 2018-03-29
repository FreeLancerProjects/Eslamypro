package com.semicolon.eslamy.Services;

import com.semicolon.eslamy.Models.AboutUsModel;
import com.semicolon.eslamy.Models.AdvisorsModel;
import com.semicolon.eslamy.Models.LangModel;
import com.semicolon.eslamy.Models.OthersModel;
import com.semicolon.eslamy.Models.QuesModel;

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
    Call<List<OthersModel>>DisplayDetails(@Field("id") String id,@Field("type")String type);

    @GET("api/questions")
    Call<List<QuesModel>>DisplayQuestion();

    @FormUrlEncoded
    @POST("api/getAnswer")
    Call<QuesModel>DisplayAnswer(@Field("lang") String lang_id,@Field("id")String question_id);

    @GET("api/advisors")
    Call<List<AdvisorsModel>>Displayadvisors();

    @GET("api/aboutus")
    Call<List<AboutUsModel>>Displayaboutus();


}
