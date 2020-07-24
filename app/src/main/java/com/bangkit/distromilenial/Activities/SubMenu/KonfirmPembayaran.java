package com.bangkit.distromilenial.Activities.SubMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bangkit.distromilenial.Activities.Emergency.WAActivity;
import com.bangkit.distromilenial.Activities.HomeActivity;
import com.bangkit.distromilenial.R;



/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class KonfirmPembayaran extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirm_pembayaran);

        Button back = findViewById(R.id.backhome);
        Button upload = findViewById(R.id.upload);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(KonfirmPembayaran.this, HomeActivity.class);
                startActivity(back);
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsapp = new Intent(KonfirmPembayaran.this, WAActivity.class);
                startActivity(whatsapp);
            }
        });

    }
}