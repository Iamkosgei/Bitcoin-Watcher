package me.kosgei.BitcoinSms.services;

import com.google.gson.JsonObject;
import me.kosgei.BitcoinSms.model.Message;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ATApi {
    @GET("messaging")
    public Call<Message> sendMessage();
}
