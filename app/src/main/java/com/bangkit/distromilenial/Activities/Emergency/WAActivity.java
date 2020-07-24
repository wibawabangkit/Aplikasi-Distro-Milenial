package com.bangkit.distromilenial.Activities.Emergency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bangkit.distromilenial.R;
/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class WAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_a);
        String contact = "+62 81297615961";

        String url = "https://api.whatsapp.com/send?phone=" + contact + "&text=Dear Admin,\n" +

        "    \n";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url)); startActivity(i);
    }
}
