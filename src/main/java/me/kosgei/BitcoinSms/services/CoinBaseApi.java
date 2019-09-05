package me.kosgei.BitcoinSms.services;

import me.kosgei.BitcoinSms.model.Bitcoin;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinBaseApi {

    @GET("prices/spot?currency=USD")
    public Call<Bitcoin> getBitcoin();
}
