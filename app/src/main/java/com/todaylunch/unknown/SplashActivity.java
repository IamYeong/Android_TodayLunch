package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Construct Locale.
        LocaleManager.setLocale(PreferencesManager.getLanguageValue(this, "LANGUAGE"));

        boolean prefFirst = PreferencesManager.getFirstRunValue(this, "FIRST");

        if (prefFirst == true) {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();


        } else {

            PreferencesManager.setFirstRunValue(this, "FIRST", true);

            Intent intent = new Intent(this, ViewPagerIntro.class);
            startActivity(intent);
            finish();


        }


    }



}
