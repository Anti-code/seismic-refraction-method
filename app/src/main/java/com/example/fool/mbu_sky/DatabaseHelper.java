package com.example.fool.mbu_sky;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fool on 11/1/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "entry_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table entries (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, LAT TEXT, LNG TEXT," +
                " VP1 FLOAT, VS1 FLOAT, H1 FLOAT, P1 FLOAT," +
                " DENS1 FLOAT, GMAX1 FLOAT, E1 FLOAT, V1 FLOAT, K1 FLOAT, T1 FLOAT, Z1 FLOAT" +
                ", VP2 FLOAT,  VS2 FLOAT, H2 FLOAT, P2 FLOAT," +
                " DENS2 FLOAT, GMAX2 FLOAT, E2 FLOAT, V2 FLOAT, K2 FLOAT, Z2 FLOAT" +
                " REC_DATE DATETIME DEFAULT CURRENT_TIMESTAMP)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS entries");
        onCreate(db);
    }
}
