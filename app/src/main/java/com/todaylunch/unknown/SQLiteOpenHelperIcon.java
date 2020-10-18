package com.todaylunch.unknown;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteOpenHelperIcon extends SQLiteOpenHelper {

    public static final int DB_VERSION2 = 1;
    public static final String DB_FILE2 = "icon.db";

    public SQLiteOpenHelperIcon(Context context) {
        super(context, DB_FILE2, null, DB_VERSION2);
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
        db.execSQL(MySQLite.SQL_CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
