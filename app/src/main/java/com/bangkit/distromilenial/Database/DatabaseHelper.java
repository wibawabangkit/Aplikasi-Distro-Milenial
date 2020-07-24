package com.bangkit.distromilenial.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    //nama database
    public static final String DATABASE_NAME = "db_apknya";
    // nama tabel dan kolom pada user
    public static final String TABLE_USER = "tb_user";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    public static final String COL_NAME = "name";

    // tabel detil pesan
    public static final String TABLE_PESAN = "pesan";
    public static final String COL_ID_PESAN = "ID_Pesan";
    public static final String COL_NAMA = "nama";
    public static final String COL_TELP = "no_telep";
    public static final String COL_ALAMAT = "alamat";
    public static final String COL_EMAIL = "email";
    public static final String COL_TANGGAL = "tanggal";
    public static final String COL_WARNA = "warna";
    public static final String COL_UKURAN = "ukuran";
    public static final String COL_JENISBAJU = "jenis_baju";
    public static final String COL_TEXT = "text_gambar";

    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("PRAGMA foreign_keys=ON");
        //Tabel  User
        db.execSQL("create table " + TABLE_USER + " (" + COL_USERNAME + " TEXT PRIMARY KEY, " + COL_PASSWORD +
                " TEXT, " + COL_NAME + " TEXT)");
        //sample record tabel user
        db.execSQL(" insert into " + TABLE_USER + " values ('admin@gmail.com','a','admin');");
        //Tabel detil pesanan
        db.execSQL("create table " + TABLE_PESAN + " ( " + COL_ID_PESAN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAMA + " TEXT, " + COL_TELP + " TEXT," + COL_ALAMAT + " TEXT, " + COL_EMAIL + " TEXT ,  " + COL_TANGGAL + " TEXT, " + COL_WARNA + " TEXT , " + COL_UKURAN + " TEXT ," +
                " " + COL_JENISBAJU + " TEXT , " + COL_TEXT + " TEXT )");
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER );
        onCreate(db);
    }


    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public boolean Register(String username, String password, String name) throws SQLException {

        @SuppressLint("Recycle") Cursor mCursor = db.rawQuery("INSERT INTO " + TABLE_USER + "(" + COL_USERNAME + ", " + COL_PASSWORD + ", " + COL_NAME + ")" +
                " VALUES (?,?,?)", new String[]{username, password, name});
        if (mCursor != null) {
            return mCursor.getCount() > 0;
        }
        return false;
    }

    public boolean Login(String username, String password) throws SQLException {
        @SuppressLint("Recycle") Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE " + COL_USERNAME + "=? AND " + COL_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            return mCursor.getCount() > 0;
        }
        return false;
    }

}