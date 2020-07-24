package com.bangkit.distromilenial.Activities;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.bangkit.distromilenial.Adapter.BaseActivity;
import com.bangkit.distromilenial.R;


/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(c, LoginActivity.class));
                finish();
            }
        },3000L);
    }
}
