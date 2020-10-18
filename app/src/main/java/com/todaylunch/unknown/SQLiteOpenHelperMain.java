package com.todaylunch.unknown;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;

public class SQLiteOpenHelperMain extends SQLiteOpenHelper {


    public static final int DB_VERSION1 = 1;
    public static final String DB_FILE1 = "inform.db";

    public SQLiteOpenHelperMain(Context context) {
        super(context, DB_FILE1, null, DB_VERSION1);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        //super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MySQLite.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
