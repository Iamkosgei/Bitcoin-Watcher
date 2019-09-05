package me.kosgei.BitcoinSms.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.kosgei.BitcoinSms.model.Bitcoin;
import me.kosgei.BitcoinSms.services.BitCoinService;
import me.kosgei.BitcoinSms.services.CoinBaseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class RetrofitController implements Callback<Bitcoin> {
    @Autowired
    BitCoinService bitCoinService;

    static final String BASE_URL = "https://api.coinbase.com/v2/";


    public void start() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CoinBaseApi coinBaseApi = retrofit.create(CoinBaseApi.class);

        Call<Bitcoin> call = coinBaseApi.getBitcoin();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Bitcoin> call, Response<Bitcoin> response) {
        if (response.isSuccessful()) {
            Bitcoin bitcoin = response.body();
            bitCoinService.saveBitcoin(bitcoin.getData());
//            System.out.println("done");
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Bitcoin> call, Throwable t) {
        t.printStackTrace();
    }
}
