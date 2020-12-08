package com.todaylunch.unknown;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class InitializeValueSetter {

    private SQLiteOpenHelperIcon dbHelper;
    private Context context;
    private ArrayList<String> arrayList;
    private Resources res;



    public InitializeValueSetter(Context context, SQLiteOpenHelperIcon dbHelper) {

        this.context = context;
        this.dbHelper = dbHelper;
        res = context.getResources();

        arrayList = new ArrayList<>();



        arrayList.add(res.getString(R.string.main_menu1));
        arrayList.add(res.getString(R.string.main_menu2));
        arrayList.add(res.getString(R.string.main_menu3));
        arrayList.add(res.getString(R.string.main_menu4));
        arrayList.add(res.getString(R.string.main_menu5));
        arrayList.add(res.getString(R.string.main_menu6));
        arrayList.add(res.getString(R.string.main_menu7));
        arrayList.add(res.getString(R.string.main_menu8));
        arrayList.add(res.getString(R.string.main_menu9));

        arrayList.add(res.getString(R.string.sub_menu1_1));
        arrayList.add(res.getString(R.string.sub_menu1_2));
        arrayList.add(res.getString(R.string.sub_menu1_3));
        arrayList.add(res.getString(R.string.sub_menu1_4));
        arrayList.add(res.getString(R.string.sub_menu1_5));
        arrayList.add(res.getString(R.string.sub_menu1_6));
        arrayList.add(res.getString(R.string.sub_menu1_7));
        arrayList.add(res.getString(R.string.sub_menu1_8));
        arrayList.add(res.getString(R.string.sub_menu1_9));

        arrayList.add(res.getString(R.string.sub_menu2_1));
        arrayList.add(res.getString(R.string.sub_menu2_2));
        arrayList.add(res.getString(R.string.sub_menu2_3));
        arrayList.add(res.getString(R.string.sub_menu2_4));
        arrayList.add(res.getString(R.string.sub_menu2_5));
        arrayList.add(res.getString(R.string.sub_menu2_6));
        arrayList.add(res.getString(R.string.sub_menu2_7));
        arrayList.add(res.getString(R.string.sub_menu2_8));
        arrayList.add(res.getString(R.string.sub_menu2_9));

        arrayList.add(res.getString(R.string.sub_menu3_1));
        arrayList.add(res.getString(R.string.sub_menu3_2));
        arrayList.add(res.getString(R.string.sub_menu3_3));
        arrayList.add(res.getString(R.string.sub_menu3_4));
        arrayList.add(res.getString(R.string.sub_menu3_5));
        arrayList.add(res.getString(R.string.sub_menu3_6));
        arrayList.add(res.getString(R.string.sub_menu3_7));
        arrayList.add(res.getString(R.string.sub_menu3_8));
        arrayList.add(res.getString(R.string.sub_menu3_9));

        arrayList.add(res.getString(R.string.sub_menu4_1));
        arrayList.add(res.getString(R.string.sub_menu4_2));
        arrayList.add(res.getString(R.string.sub_menu4_3));
        arrayList.add(res.getString(R.string.sub_menu4_4));
        arrayList.add(res.getString(R.string.sub_menu4_5));
        arrayList.add(res.getString(R.string.sub_menu4_6));
        arrayList.add(res.getString(R.string.sub_menu4_7));
        arrayList.add(res.getString(R.string.sub_menu4_8));
        arrayList.add(res.getString(R.string.sub_menu4_9));

        arrayList.add(res.getString(R.string.sub_menu5_1));
        arrayList.add(res.getString(R.string.sub_menu5_2));
        arrayList.add(res.getString(R.string.sub_menu5_3));
        arrayList.add(res.getString(R.string.sub_menu5_4));
        arrayList.add(res.getString(R.string.sub_menu5_5));
        arrayList.add(res.getString(R.string.sub_menu5_6));
        arrayList.add(res.getString(R.string.sub_menu5_7));
        arrayList.add(res.getString(R.string.sub_menu5_8));
        arrayList.add(res.getString(R.string.sub_menu5_9));

        arrayList.add(res.getString(R.string.sub_menu_6_1));
        arrayList.add(res.getString(R.string.sub_menu_6_2));
        arrayList.add(res.getString(R.string.sub_menu_6_3));
        arrayList.add(res.getString(R.string.sub_menu_6_4));
        arrayList.add(res.getString(R.string.sub_menu_6_5));
        arrayList.add(res.getString(R.string.sub_menu_6_6));
        arrayList.add(res.getString(R.string.sub_menu_6_7));
        arrayList.add(res.getString(R.string.sub_menu_6_8));
        arrayList.add(res.getString(R.string.sub_menu_6_9));

        arrayList.add(res.getString(R.string.sub_menu_7_1));
        arrayList.add(res.getString(R.string.sub_menu_7_2));
        arrayList.add(res.getString(R.string.sub_menu_7_3));
        arrayList.add(res.getString(R.string.sub_menu_7_4));
        arrayList.add(res.getString(R.string.sub_menu_7_5));
        arrayList.add(res.getString(R.string.sub_menu_7_6));
        arrayList.add(res.getString(R.string.sub_menu_7_7));
        arrayList.add(res.getString(R.string.sub_menu_7_8));
        arrayList.add(res.getString(R.string.sub_menu_7_9));

        arrayList.add(res.getString(R.string.sub_menu_8_1));
        arrayList.add(res.getString(R.string.sub_menu_8_2));
        arrayList.add(res.getString(R.string.sub_menu_8_3));
        arrayList.add(res.getString(R.string.sub_menu_8_4));
        arrayList.add(res.getString(R.string.sub_menu_8_5));
        arrayList.add(res.getString(R.string.sub_menu_8_6));
        arrayList.add(res.getString(R.string.sub_menu_8_7));
        arrayList.add(res.getString(R.string.sub_menu_8_8));
        arrayList.add(res.getString(R.string.sub_menu_8_9));

        arrayList.add(res.getString(R.string.sub_menu_9_1));
        arrayList.add(res.getString(R.string.sub_menu_9_2));
        arrayList.add(res.getString(R.string.sub_menu_9_3));
        arrayList.add(res.getString(R.string.sub_menu_9_4));
        arrayList.add(res.getString(R.string.sub_menu_9_5));
        arrayList.add(res.getString(R.string.sub_menu_9_6));
        arrayList.add(res.getString(R.string.sub_menu_9_7));
        arrayList.add(res.getString(R.string.sub_menu_9_8));
        arrayList.add(res.getString(R.string.sub_menu_9_9));



    }

    public void toSQLiteValueSetter() {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        for (int i = 1; i <= 90; i++) {

            String insert = MySQLite.SQL_INSERT2_HELPER(i, arrayList.get(i - 1), resourceIdConverter("drawable", "drawable_image_" + i));
            db.execSQL(insert);

        }

        db.close();

    }

    private int resourceIdConverter(String file, String name) {

        int tempId = context.getResources().getIdentifier("com.todaylunch.unknown:" + file + "/" + name,null,null);

        return tempId;
    }

}
