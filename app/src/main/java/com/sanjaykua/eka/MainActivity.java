package com.sanjaykua.eka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sanjaykua.eka.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.github.com/search/").addConverterFactory(GsonConverterFactory.create()).build();

        ListInterface listInterface=retrofit.create(ListInterface.class);

        Call<ResponseData> responseDataCall=listInterface.showNames();

        final Dialog dialog= new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.progress);
        dialog.setCancelable(false);
        dialog.show();

        responseDataCall.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {


                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false);
                binding.rec.setLayoutManager(linearLayoutManager);
                binding.rec.setAdapter(new Recadp(MainActivity.this,response.body().getItemsList()));
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

            }
        });
    }
}
