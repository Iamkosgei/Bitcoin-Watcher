package me.kosgei.BitcoinSms.controller;

import me.kosgei.BitcoinSms.model.Bitcoin;
import me.kosgei.BitcoinSms.services.BitCoinService;
import me.kosgei.BitcoinSms.services.CoinBaseApi;
import me.kosgei.BitcoinSms.util.RetrofitClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Component
public class RetrofitController implements Callback<Bitcoin> {
    @Autowired
    BitCoinService bitCoinService;

    static final String BASE_URL = "https://api.coinbase.com/v2/";

    public void start() {
        CoinBaseApi coinBaseApi = RetrofitClient.getClient(BASE_URL).create(CoinBaseApi.class);
        Call<Bitcoin> call = coinBaseApi.getBitcoin();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Bitcoin> call, Response<Bitcoin> response) {
        if (response.isSuccessful()) {
            Bitcoin bitcoin = response.body();
            bitCoinService.saveBitcoin(bitcoin.getData());
        } else {
            System.out.println(response.errorBody());
        }
    }
    @Override
    public void onFailure(Call<Bitcoin> call, Throwable t) {
        t.printStackTrace();
    }
}
