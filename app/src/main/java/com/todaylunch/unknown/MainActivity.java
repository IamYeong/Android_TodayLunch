package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private SQLiteOpenHelperIcon dbHelperIcon = null;
    private SQLiteOpenHelperSetting dbHelperDesign = null;
    public static ArrayList<Integer> IMAGE_ID_ARRAYLIST = new ArrayList<>();

    public static int COLOR_NUMBER;
    public static int FONT_NUMBER;
    public static int BACKGROUND_NUMBER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init_value();

        load_value();

        load_design();



        tabLayout = (TabLayout) findViewById(R.id.tab_main);


        tabLayout.getTabAt(0).setIcon(R.drawable.tab_image_menu);
        tabLayout.getTabAt(1).setIcon(R.drawable.tab_image_list);
        tabLayout.getTabAt(2).setIcon(R.drawable.tab_image_random);
        tabLayout.getTabAt(3).setIcon(R.drawable.tab_image_gear);

        this.getWindow().setStatusBarColor(COLOR_NUMBER);
        //Fragment code

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame_main, new Fragment1());
        ft.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switchFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }//onCreate

    //Change fragment for Tablayout
    private void switchFragment(int pos) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (pos) {
            case 0 : ft.replace(R.id.frame_main, new Fragment1());
                ft.commit();
                break;

            case 1 : ft.replace(R.id.frame_main, new fragment2());
                ft.commit();
                break;

            case 2 : ft.replace(R.id.frame_main, new fragment3());
                ft.commit();
                break;

            case 3 : ft.replace(R.id.frame_main, new fragment4());
                ft.commit();
                break;
        }

    }

    private void init_value() {
        dbHelperIcon = new SQLiteOpenHelperIcon(this);
        dbHelperDesign = new SQLiteOpenHelperSetting(this);

    }

    private void load_value() {

        SQLiteDatabase db2 = dbHelperIcon.getReadableDatabase();
        Cursor cursor2 = db2.rawQuery(MySQLite.SQL_SELECT2, null);
        drawableImageIdSetter(73);

        if (cursor2.getCount() == 0) {
            cursor2.close();
            db2.close();
            start_value_add();
        }

        cursor2.close();
        db2.close();

    }

    private void load_design() {

        COLOR_NUMBER = PreferencesManager.getThemeValue(this, "THEME");
        FONT_NUMBER = PreferencesManager.getFontValue(this, "FONT");
        BACKGROUND_NUMBER = PreferencesManager.getButtonValue(this, "BUTTON");

        Log.d("Preference value :", COLOR_NUMBER + ", " + FONT_NUMBER + ", " + BACKGROUND_NUMBER);

    }


    private void start_value_add() {

        InitializeValueSetter initValue = new InitializeValueSetter(this);
        initValue.toSQLiteValueSetter();

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

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.updateResources(newBase));
    }


}
