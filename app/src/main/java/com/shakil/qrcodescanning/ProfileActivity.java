package com.shakil.qrcodescanning;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shakil.qrcodescanning.model.Profile;
import com.shakil.qrcodescanning.onboard.SuccessActivity;

public class ProfileActivity extends AppCompatActivity {
    private ImageView back;
    private Profile profile;
    private TextView Name,DOB,Email,Mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initUI();
    }

    private void initUI() {
        back = findViewById(R.id.back);
        Name = findViewById(R.id.Name);
        DOB = findViewById(R.id.DOB);
        Email = findViewById(R.id.Email);
        Mobile = findViewById(R.id.Mobile);

        getProfileData();

        if (profile != null){
            Name.setText(profile.getName());
            DOB.setText(profile.getdate_of_birth());
            Email.setText(profile.getEmail());
            Mobile.setText(profile.getPhone());
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, SuccessActivity.class));
            }
        });

    }

    private void getProfileData() {
        profile = (Profile) getIntent().getSerializableExtra("profile");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ProfileActivity.this,SuccessActivity.class));
    }
}