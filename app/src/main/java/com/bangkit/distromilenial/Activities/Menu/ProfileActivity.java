package com.bangkit.distromilenial.Activities.Menu;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import com.bangkit.distromilenial.Database.DatabaseHelper;
import com.bangkit.distromilenial.R;
import com.bangkit.distromilenial.Session.SessionManager;
import java.util.HashMap;


/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class ProfileActivity extends AppCompatActivity {

    protected Cursor cursor;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    SessionManager session;
    String name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        email = user.get(SessionManager.KEY_EMAIL);

        cursor = db.rawQuery("SELECT * FROM TB_USER WHERE username = '" + email + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            name = cursor.getString(2);
        }

        TextView lblName = findViewById(R.id.name);
        TextView lblEmail = findViewById(R.id.email);
        lblName.setText(name);
        lblEmail.setText(email);

    }

}