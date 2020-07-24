package com.bangkit.distromilenial.Activities.Menu;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bangkit.distromilenial.Activities.SubMenu.KonfirmPembayaran;
import com.bangkit.distromilenial.Database.DatabaseHelper;
import com.bangkit.distromilenial.R;




/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class RequestActivity extends AppCompatActivity {
    Cursor cursor;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    EditText namanya, notelpnya, alamatnya, emailnya, sTanggal, warnanya, ukuran, jenis_baju, text_gambarnya;
    String edit;
    Button req;
    int ID_Pesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        // memanggil button request dan variabel tanggal
        req = findViewById(R.id.request);
        // memanggil variabel input tex form
        namanya = findViewById(R.id.nama);
        notelpnya = findViewById(R.id.notelepon);
        alamatnya = findViewById(R.id.alamat);
        emailnya = findViewById(R.id.email_penerima);
        warnanya = findViewById(R.id.warna);
        sTanggal = findViewById(R.id.tanggal_pesan);
        jenis_baju = findViewById(R.id.jenisbaju);
        ukuran = findViewById(R.id.ukuran);
        text_gambarnya = findViewById(R.id.textdesign);
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();


        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //meringkas variabel dengan variabel array edit
                edit = namanya.getText().toString();
                edit = notelpnya.getText().toString();
                edit = alamatnya.getText().toString();
                edit = emailnya.getText().toString();
                edit = warnanya.getText().toString();
                edit = jenis_baju.getText().toString();
                edit = ukuran.getText().toString();
                edit = text_gambarnya.getText().toString();
                //penggunaan array variabel edit untuk mendeklarasikan jika form kosong
                if (edit.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Data Harus Lengkap!", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog dialog = new AlertDialog.Builder(RequestActivity.this)
                            .setTitle("Ingin Memesan?")
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        db.execSQL("insert into pesan (  nama, no_telep, alamat, email, tanggal,warna,ukuran,jenis_baju,text_gambar) values('" +
                                                namanya.getText().toString() + "','" +
                                                notelpnya.getText().toString() + "','" +
                                                alamatnya.getText().toString() + "','" +
                                                emailnya.getText().toString() + "','" +
                                                sTanggal.getText().toString() + "','" +
                                                warnanya.getText().toString() + "','" +
                                                ukuran.getText().toString() + "','" +
                                                jenis_baju.getText().toString() + "','" +
                                                text_gambarnya.getText().toString() + "')");


                                        Toast.makeText(getApplicationContext(), "Pesan Berhasil", Toast.LENGTH_LONG).show();
                                        Intent konfirmasi_pembayaran;
                                        konfirmasi_pembayaran = new Intent(RequestActivity.this, KonfirmPembayaran.class);
                                        startActivity(konfirmasi_pembayaran);
                                        finish();
                                    }
                                    catch (Exception e) {
                                        Toast.makeText(RequestActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            })
                            .setNegativeButton("Tidak", null)
                            .create();
                    dialog.show();
                }
            }
        });
        setupToolbar();
    }
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.pesan);
        toolbar.setTitle("Form Pemesanan");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}