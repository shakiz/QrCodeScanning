package com.shakil.qrcodescanning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shakil.qrcodescanning.adapter.TicketLogListAdapter;
import com.shakil.qrcodescanning.model.Ticket;
import com.shakil.qrcodescanning.onboard.SuccessActivity;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketLogActivity extends AppCompatActivity {

    private ArrayList<Ticket> ticketLogList;
    private AllApiService allApiService;
    private ImageView sadIcon;
    private TextView noData;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_log);

        initUI();
    }

    private void initUI() {
        sadIcon = findViewById(R.id.SadIcon);
        noData = findViewById(R.id.NoDataMessage);
        back = findViewById(R.id.back);
        ticketLogList = new ArrayList<>();

        new BackgroundDataLoad().execute();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TicketLogActivity.this, SuccessActivity.class));
            }
        });
    }

    private void loadListView() {
        TicketLogListAdapter adapter = new TicketLogListAdapter(ticketLogList,this);
        RecyclerView recyclerView = findViewById(R.id.ticketLogList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    private class BackgroundDataLoad extends AsyncTask<String, Void, String> {
        private ProgressDialog dialog;

        public BackgroundDataLoad() {
            dialog = new ProgressDialog(TicketLogActivity.this);
        }

        @Override
        protected void onPreExecute() {
            dialog.setMessage("Fetching data.....");
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            getLog();
            return "done";
        }

        @Override
        protected void onPostExecute(String result) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (ticketLogList.size() > 0){
                        if (dialog.isShowing()) {
                            loadListView();
                            dialog.dismiss();
                        }
                    }
                    else{
                        dialog.dismiss();
                        sadIcon.setVisibility(View.VISIBLE);
                        noData.setVisibility(View.VISIBLE);
                    }
                }
            }, 2000);

        }

    }

    private void getLog() {
        String url = "http://157.245.231.80/api/test/android/scan-log/";
        allApiService = APIClient.getClient(url).create(AllApiService.class);

        Call<ArrayList<Ticket>> call = allApiService.getTicketLogs(url);
        call.enqueue(new Callback<ArrayList<Ticket>>() {
            @Override
            public void onResponse(Call<ArrayList<Ticket>> call, Response<ArrayList<Ticket>> response) {
                if (response != null){
                    if (response.body().size() != 0){
                        for(int start = 0;start< response.body().size();start++){
                            Ticket ticket = response.body().get(start);
                            ticketLogList.add(new Ticket(ticket.getTicket_id(),ticket.getScan_date(),ticket.getScan_time(),ticket.getStatus()));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Ticket>> call, Throwable t) {
                call.cancel();
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TicketLogActivity.this,SuccessActivity.class));
    }

}
