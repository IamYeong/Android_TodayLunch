package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;


import static com.todaylunch.unknown.MainActivity.IMAGE_ID_ARRAYLIST;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        NewThread nt = new NewThread(this);
        nt.execute();

        //Construct Locale.

    }

    private class NewThread extends AsyncTask<Integer, Integer, Boolean> {

        private Context context;
        private SQLiteOpenHelperIcon dbHelper;
        private InitializeValueSetter initializer;


        private NewThread(Context context) {

            this.context = context;

        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            LocaleManager.setLocale(PreferencesManager.getLanguageValue(context, "LANGUAGE"));
            boolean prefFirst = PreferencesManager.getFirstRunValue(context, "FIRST");

            if (prefFirst == true) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();


            } else {

                PreferencesManager.setFirstRunValue(context, "FIRST", true);

                Intent intent = new Intent(context, ViewPagerIntro.class);
                startActivity(intent);
                finish();


            }

        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected Boolean doInBackground(Integer... integers) {

            dbHelper = new SQLiteOpenHelperIcon(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT2, null);

            if (cursor.getCount() == 0) {
                initializer = new InitializeValueSetter(context, dbHelper);
                initializer.toSQLiteValueSetter();
            }

            drawableImageIdSetter(191);

            return null;
        }
    }

    private void drawableImageIdSetter(int image_volume) {

        for (int i = 1; i <= image_volume; i++) {
            IMAGE_ID_ARRAYLIST.add(resourceIdConverter("drawable", "drawable_image_" + i));
        }


    }
    private int resourceIdConverter(String file, String name) {

        int tempId = getResources().getIdentifier("com.todaylunch.unknown:" + file + "/" + name,null,null);

        return tempId;
    }



}
