package com.bangkit.distromilenial.Activities.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.bangkit.distromilenial.Activities.Emergency.SosmedActivity;
import com.bangkit.distromilenial.Activities.Emergency.TokpedActivity;
import com.bangkit.distromilenial.Activities.Emergency.WAActivity;
import com.bangkit.distromilenial.R;

import java.util.Calendar;
import java.util.Date;
/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class ContactActivity extends AppCompatActivity {
    TextView tvToday, tvMainSalam;
    String hariIni;
    Animation animTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button Tokped = findViewById(R.id.Tokped);
        Button WA = findViewById(R.id.btn_WA);
        Button Sosmed = findViewById(R.id.btn_HB);

        Tokped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContactActivity.this, TokpedActivity.class);
                startActivity(i);
            }
        });

        WA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(ContactActivity.this, WAActivity.class);
                startActivity(p);
            }
        });

        Sosmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent W = new Intent(ContactActivity.this, SosmedActivity.class);
                startActivity(W);
            }
        });

        tvToday = findViewById(R.id.tvDate);
        tvMainSalam = findViewById(R.id.tvMainSalam);
        animTv = AnimationUtils.loadAnimation(this, R.anim.anim_tv);
        tvMainSalam.startAnimation(animTv);

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
        String tanggal = (String) DateFormat.format("d", date);
        String monthNumber = (String) DateFormat.format("M", date);
        String year = (String) DateFormat.format("yyyy", date);

        int month = Integer.parseInt(monthNumber);
        String bulan = null;
        if (month == 1) {
            bulan = "Januari";
        } else if (month == 2) {
            bulan = "Februari";
        } else if (month == 3) {
            bulan = "Maret";
        } else if (month == 4) {
            bulan = "April";
        } else if (month == 5) {
            bulan = "Mei";
        } else if (month == 6) {
            bulan = "Juni";
        } else if (month == 7) {
            bulan = "Juli";
        } else if (month == 8) {
            bulan = "Agustus";
        } else if (month == 9) {
            bulan = "September";
        } else if (month == 10) {
            bulan = "Oktober";
        } else if (month == 11) {
            bulan = "November";
        } else if (month == 12) {
            bulan = "Desember";
        }
        String formatFix = hariIni + ", " + tanggal + " " + bulan + " " + year;
        tvToday.setText(formatFix);
    }

}
