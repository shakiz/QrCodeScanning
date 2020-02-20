package com.shakil.qrcodescanning.onboard;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shakil.qrcodescanning.ProfileActivity;
import com.shakil.qrcodescanning.QrCodeScanActivity;
import com.shakil.qrcodescanning.R;
import com.shakil.qrcodescanning.TicketLogActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class SuccessActivity extends AppCompatActivity {

    private Button navigateToProfile , navigateToTicketLog, scanAgain;
    private TextView successOrFailed;
    private ImageView successOrFailedIcon;
    private CircleImageView faceIcon;
    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        initUI();
    }

    private void initUI() {

        navigateToProfile = findViewById(R.id.profile);
        scanAgain = findViewById(R.id.scanAgain);
        navigateToTicketLog = findViewById(R.id.ticketLog);
        successOrFailed = findViewById(R.id.successOrFailedText);
        successOrFailedIcon = findViewById(R.id.successOrFailedIcon);
        faceIcon = findViewById(R.id.faceIcon);

        getExtra();

        if (id.equals("")){
            successOrFailed.setText(getResources().getString(R.string.invalid));
            faceIcon.setImageResource(R.drawable.ic_sad);
            successOrFailedIcon.setImageResource(R.drawable.ic_invalid);
        }
        else {
            successOrFailed.setText(getResources().getString(R.string.success));
            faceIcon.setImageResource(R.drawable.face_happy);
            successOrFailedIcon.setImageResource(R.drawable.ic_success);
        }

        navigateToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuccessActivity.this, ProfileActivity.class));
            }
        });

        navigateToTicketLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuccessActivity.this, TicketLogActivity.class));
            }
        });

        scanAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuccessActivity.this,QrCodeScanActivity.class));
            }
        });

    }

    private void getExtra() {
        id = getIntent().getStringExtra("id");
    }
}
