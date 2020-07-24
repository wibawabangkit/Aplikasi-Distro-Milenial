package com.bangkit.distromilenial.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.bangkit.distromilenial.Activities.Menu.ContactActivity;
import com.bangkit.distromilenial.Activities.Menu.BeliActivity;
import com.bangkit.distromilenial.Activities.Menu.ProfileActivity;
import com.bangkit.distromilenial.Activities.Menu.RequestActivity;
import com.bangkit.distromilenial.Adapter.AlertDialogManager;
import com.bangkit.distromilenial.R;
import com.bangkit.distromilenial.Session.SessionManager;

import java.util.Calendar;
import java.util.Date;



/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class HomeActivity extends AppCompatActivity implements  View.OnClickListener {
    String hariIni;
    TextView tvToday, tvMainSalam;
    Animation animTv;
    SessionManager session;
    AlertDialogManager alert = new AlertDialogManager();
    Button btnLogout;
    private CardView cardviewProfile, cardviewshopping, cardviewemergency, cardreq;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardviewProfile = (CardView) findViewById(R.id.profile_card);
        cardviewshopping = (CardView) findViewById(R.id.shopping_card);
        cardviewemergency = (CardView) findViewById(R.id.emergency_card);
        cardreq = (CardView) findViewById(R.id.Req_card);
        tvToday = findViewById(R.id.tvDate);
        tvMainSalam = findViewById(R.id.tvMainSalam);
        animTv = AnimationUtils.loadAnimation(this, R.anim.anim_tv);
        tvMainSalam.startAnimation(animTv);



        cardviewProfile.setOnClickListener(this);
        cardviewshopping.setOnClickListener(this);
        cardviewemergency.setOnClickListener(this);
        cardreq.setOnClickListener(this);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        btnLogout = findViewById(R.id.out);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog dialog = new AlertDialog.Builder(HomeActivity.this)
                        .setTitle("Anda yakin ingin keluar ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                session.logoutUser();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .create();
                dialog.show();
            }
        });



        Date dateNow = Calendar.getInstance().getTime();
        hariIni = (String) DateFormat.format("EEEE", dateNow);
        if (hariIni.equalsIgnoreCase("sunday")) {
            hariIni = "Minggu";
        } else if (hariIni.equalsIgnoreCase("monday")) {
            hariIni = "Senin";
        } else if (hariIni.equalsIgnoreCase("tuesday")) {
            hariIni = "Selasa";
        } else if (hariIni.equalsIgnoreCase("wednesday")) {
            hariIni = "Rabu";
        } else if (hariIni.equalsIgnoreCase("thursday")) {
            hariIni = "Kamis";
        } else if (hariIni.equalsIgnoreCase("friday")) {
            hariIni = "Jumat";
        } else if (hariIni.equalsIgnoreCase("saturday")) {
            hariIni = "Sabtu";
        }

        getToday();
        setSalam();
    }

    @Override
    public void onClick(View view) {
        //proses pengclick
        Intent i;

        switch (view.getId()) {
            case R.id.profile_card:
                i = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(i);
                break;
            case R.id.shopping_card:
                i = new Intent(HomeActivity.this, BeliActivity.class);
                startActivity(i);
                break;
            case R.id.Req_card:
                i = new Intent(HomeActivity.this, RequestActivity.class);
                startActivity(i);
                break;
            case R.id.emergency_card:
                i = new Intent(HomeActivity.this, ContactActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    private void setSalam() {
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        if (timeOfDay >= 0 && timeOfDay < 12) {
            tvMainSalam.setText("Selamat Pagi");
        } else if (timeOfDay >= 12 && timeOfDay < 15) {
            tvMainSalam.setText("Selamat Siang");
        } else if (timeOfDay >= 15 && timeOfDay < 18) {
            tvMainSalam.setText("Selamat Sore");
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            tvMainSalam.setText("Selamat Malam");
        }
    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String DATE = (String) DateFormat.format("d", date);
        String monthNumber = (String) DateFormat.format("M", date);
        String year = (String) DateFormat.format("yyyy", date);

        int bulan = Integer.parseInt(monthNumber);
        String month = null;
        if (bulan == 1) {
            month = "Januari";
        } else if (bulan == 2) {
            month = "Februari";
        } else if (bulan == 3) {
            month = "Maret";
        } else if (bulan == 4) {
            month = "April";
        } else if (bulan == 5) {
            month = "Mei";
        } else if (bulan == 6) {
            month = "Juni";
        } else if (bulan == 7) {
            month = "Juli";
        } else if (bulan == 8) {
            month = "Agustus";
        } else if (bulan == 9) {
            month = "September";
        } else if (bulan == 10) {
            month = "Oktober";
        } else if (bulan == 11) {
            month = "November";
        } else if (bulan == 12) {
            month = "Desember";
        }
        String formatFix = hariIni + ", " + DATE + " " + month + " " + year;
        tvToday.setText(formatFix);
    }
}


