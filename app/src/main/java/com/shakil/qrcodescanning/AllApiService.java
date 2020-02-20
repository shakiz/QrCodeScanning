package com.shakil.qrcodescanning;

import com.shakil.qrcodescanning.model.Ticket;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface AllApiService {
    //Call for trending repositories
    @GET
    Call<ArrayList<Ticket>> getTicketLogs(@Url String url);

}
