package me.kosgei.BitcoinSms.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.kosgei.BitcoinSms.model.AtPayload;
import me.kosgei.BitcoinSms.services.ATApi;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SMSSenderController implements Callback<ResponseBody> {
    private static final String BASE_URL = "https://api.sandbox.africastalking.com/version1/";

    public void sendSMS(AtPayload atPayload) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", "sandbox")
                .addFormDataPart("to", "+254712201019")
                .addFormDataPart("message", atPayload.getMessage())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ATApi atApi = retrofit.create(ATApi.class);
        Call<ResponseBody> call = atApi.sendMessage(requestBody);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        System.out.println(response.code());
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable throwable) {
        throwable.printStackTrace();
    }




}
