package com.bangkit.distromilenial.Activities.Emergency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bangkit.distromilenial.R;


/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class SosmedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sosmed);


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"wibawabangkit31@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Keluhan Pelanggan");
        intent.putExtra(Intent.EXTRA_TEXT, "Dear Admin,\n" +

                "    \n" +
                " Nama = \n" +
                "  \n" +
                " Pesanan = \n" +
                "    \n" +
                " Tanggal Pesan = \n" +
                "    \n" +
                "    \n" +
                "Best Regrads,\n" +
                "Pelanggan");

        try {
            startActivity(Intent.createChooser(intent, "Ingin Mengirim Pesan/Email ?"));
        } catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }

    }}