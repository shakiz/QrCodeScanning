package com.shakil.qrcodescanning;

import com.shakil.qrcodescanning.model.Profile;
import com.shakil.qrcodescanning.model.Ticket;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface AllApiService {
    @GET
    Call<ArrayList<Ticket>> getTicketLogs(@Url String url);

    @POST("test/android/get-user-info")
    Call<Profile> getProfile(@Body String ticket_id);
}
