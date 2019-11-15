package com.sanjaykua.eka;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface ListInterface {

    String url="repositories?q=android+org:google";
    @GET(url)
    Call<ResponseData> showNames();


    @GET(url)
    Call<ResponseData> showDetails();
}
