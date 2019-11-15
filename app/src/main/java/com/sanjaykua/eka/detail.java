package com.sanjaykua.eka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.sanjaykua.eka.databinding.ActivityDetailBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class detail extends AppCompatActivity {

    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(detail.this,R.layout.activity_detail);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.github.com/search/").addConverterFactory(GsonConverterFactory.create()).build();

        ListInterface listInterface=retrofit.create(ListInterface.class);

        Call<ResponseData> responseData=listInterface.showDetails();

        responseData.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {


            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

            }
        });
    }
}
