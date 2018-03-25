package com.semicolon.eslamy.Services;

import com.semicolon.eslamy.Models.LangModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Delta on 25/03/2018.
 */

public interface Service {

    @GET("api/languages")
    Call<List<LangModel>>DisplayLanguage();
}
