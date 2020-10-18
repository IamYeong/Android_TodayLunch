package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //if first run, viewpager intnet. or not main activity intent.

        pref = getSharedPreferences("FIRST", MODE_PRIVATE);
        boolean isFirst = pref.getBoolean("isFirst", true);

        System.out.println(isFirst);

        firstRunCheck(isFirst);

        /*
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


         */

    }

    private void firstRunCheck(boolean pref) {

        if (pref) {

            Intent intent = new Intent(this, ViewPagerIntro.class);
            startActivity(intent);
            finish();

        } else {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        }

    }

}
