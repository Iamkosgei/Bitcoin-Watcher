package me.kosgei.BitcoinSms.services;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ATApi {
    @Headers({"apiKey: ",
            "Accept: application/json",})
    @POST("messaging")
    Call<ResponseBody> sendMessage(@Body RequestBody body);
}
