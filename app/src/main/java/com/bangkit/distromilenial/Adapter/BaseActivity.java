package com.bangkit.distromilenial.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;

import androidx.appcompat.app.AppCompatActivity;


/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class BaseActivity extends AppCompatActivity {
    protected Context c;
    public AlphaAnimation btnAnimasi = new AlphaAnimation(1F, 0.5F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c = this;

    }
}