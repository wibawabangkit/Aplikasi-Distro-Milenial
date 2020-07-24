package com.bangkit.distromilenial.Activities.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



import com.bangkit.distromilenial.R;

import java.util.Calendar;

/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class BeliActivity extends AppCompatActivity {
    TextView  tvMainSalam;
    Animation animTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli);
        ImageView showfragment1 = (ImageView) findViewById(R.id.fragment1);
        ImageView showfragment2 = (ImageView) findViewById(R.id.fragment2);
        ImageView showfragment3 = (ImageView) findViewById(R.id.fragment3);
        ImageView showfragment4 = (ImageView) findViewById(R.id.fragment4);
        ImageView showfragment5 = (ImageView) findViewById(R.id.fragment5);
        final ImageView showfragment6 = (ImageView) findViewById(R.id.fragment6);
        ImageView showrequest1 = (ImageView) findViewById(R.id.req1);
        ImageView showrequest2 = (ImageView) findViewById(R.id.req2);
        tvMainSalam = findViewById(R.id.tvMainSalam);
        animTv = AnimationUtils.loadAnimation(this, R.anim.anim_tv);
        tvMainSalam.startAnimation(animTv);

        //Product
        showfragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragment1 = new Intent(BeliActivity.this, RequestActivity.class);
                startActivity(fragment1);
            }
        });
        showfragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fragment2 = new Intent(BeliActivity.this, RequestActivity.class);
                startActivity(fragment2);
            }
        });
        showfragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fragment3 = new Intent(BeliActivity.this, RequestActivity.class);
                startActivity(fragment3);
            }
        });
        showfragment4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fragment4 = new Intent(BeliActivity.this, RequestActivity.class);
                startActivity(fragment4);
            }
        });
        showfragment5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fragment5 = new Intent(BeliActivity.this, RequestActivity.class);
                startActivity(fragment5);
            }
        });
        showfragment6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fragment6 = new Intent(BeliActivity.this, RequestActivity.class);
                startActivity(fragment6);
            }
        });
        showrequest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent req1 = new Intent(BeliActivity.this, RequestActivity.class);
                startActivity(req1);
            }
        });
        showrequest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent req2 = new Intent(BeliActivity.this, RequestActivity.class);
                startActivity(req2);
            }

        });
        setSalam();

    }
    //ucapan selamat
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
}