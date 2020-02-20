package com.shakil.qrcodescanning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

public class TicketLogActivity extends AppCompatActivity {

    GetTicketLog getTicketLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_log);

        initUI();
    }

    private void initUI() {
        getTicketLog = new GetTicketLog();
        getTicketLog.getTicketLog(new GetTicketLog.onLoadCompleted() {
            @Override
            public void onComplete() {
                loadListView();
            }
        });
    }

    private void loadListView() {
        RecyclerView recyclerView = findViewById(R.id.ticketLogList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


}
