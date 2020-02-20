package com.shakil.qrcodescanning.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shakil.qrcodescanning.ProfileActivity;
import com.shakil.qrcodescanning.R;
import com.shakil.qrcodescanning.TicketLogActivity;

public class MainActivity extends AppCompatActivity {

    private Button navigateToProfile , navigateToTicketLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {

        navigateToProfile = findViewById(R.id.profile);
        navigateToTicketLog = findViewById(R.id.ticketLog);

        navigateToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        navigateToTicketLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TicketLogActivity.class));
            }
        });

    }
}
