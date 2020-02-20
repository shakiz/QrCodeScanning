package com.shakil.qrcodescanning.onboard;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shakil.qrcodescanning.APIClient;
import com.shakil.qrcodescanning.AllApiService;
import com.shakil.qrcodescanning.ProfileActivity;
import com.shakil.qrcodescanning.QrCodeScanActivity;
import com.shakil.qrcodescanning.R;
import com.shakil.qrcodescanning.TicketLogActivity;
import com.shakil.qrcodescanning.model.Profile;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuccessActivity extends AppCompatActivity {

    private Button navigateToProfile , navigateToTicketLog, scanAgain;
    private TextView successOrFailed;
    private ImageView successOrFailedIcon;
    private CircleImageView faceIcon;
    private AllApiService allApiService;
    private String id = "";
    private Profile profile;

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

        new BackgroundDataLoad().execute();

        if (id == null){
            Log.v("no id","<><>null");
        }
        else if (id.equals("")){
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
                startActivity(new Intent(SuccessActivity.this, ProfileActivity.class).putExtra("profile",profile));
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

    private class BackgroundDataLoad extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            Log.v("Fetching data.....","Profile Data fetching");
        }

        @Override
        protected String doInBackground(String... strings) {
            getLog();
            return "done";
        }

        @Override
        protected void onPostExecute(String result) {
            Log.v("SUCCESS","PROFILE DATA");
        }

    }

    private void getLog() {
        String url = "http://157.245.231.80/api/";
        allApiService = APIClient.getClient(url).create(AllApiService.class);

        Call<Profile> call = allApiService.getProfile(id);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.code() == 200){
                    profile.setName(response.body().getName());
                    profile.setDate_of_birth(response.body().getdate_of_birth());
                    profile.setPhone(response.body().getPhone());
                    profile.setEmail(response.body().getEmail());
                    profile.setProfile_picture(response.body().getProfile_picture());
                    profile.setTicket_validity(response.body().getTicket_validity());
                }
                else{
                    Log.v("Response",">>> Null");
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                call.cancel();
            }
        });

    }

    private void getExtra() {
        id = getIntent().getStringExtra("id");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SuccessActivity.this,QrCodeScanActivity.class));
    }
}
