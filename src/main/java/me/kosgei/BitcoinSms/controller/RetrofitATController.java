package me.kosgei.BitcoinSms.controller;

import me.kosgei.BitcoinSms.model.Message;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitATController implements Callback<Message> {

    static final String BASE_URL = "https://api.sandbox.africastalking.com/version1/";


    @Override
    public void onResponse(Call<Message> call, Response<Message> response) {

    }

    @Override
    public void onFailure(Call<Message> call, Throwable t) {
        t.printStackTrace();
    }
}
