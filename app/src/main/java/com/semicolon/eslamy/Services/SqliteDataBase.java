package com.semicolon.eslamy.Services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Delta on 30/03/2018.
 */

public class SqliteDataBase extends SQLiteOpenHelper {
    private static final String db_name = "Eslamy_db";
    private static final int version = 1;

    private static final String Language_table="Languages";

    public SqliteDataBase(Context context) {
        super(context, db_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
