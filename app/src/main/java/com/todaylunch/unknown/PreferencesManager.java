package com.todaylunch.unknown;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

public class PreferencesManager {

    public static final String PREFERENCES_NAME = "build_preference";

    private static final int FONT_DEFAULT_VALUE = 5;
    private static final int THEME_DEFAULT_VALUE = -11773841;
    //private static final int THEME_DEFAULT_VALUE2 = 0;
    private static final String LANGUAGE_DEFAULT_VALUE = Locale.getDefault().getLanguage();
    private static final int BACKGROUND_DFAULT_VALUE = -1315603;
    private static final int BUTTON_DEFAULT_VALUE = 6;
    private static final int APPS_DEFAULT_VALUE = -3422783;
    private static final boolean FIRST_RUN_DEFAULT_VALUE = false;

    private static SharedPreferences getPreference(Context context) {

        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

    }

    public static void setAppsColorValue(Context context, String key, int value) {

        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();

    }

    public static void setBackgroundValue(Context context, String key, int value) {

        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();

    }


    public static void setFirstRunValue(Context context, String key, boolean value) {

        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }


    public static void setFontValue(Context context, String key, int value) {
        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void setButtonValue(Context context, String key, int value) {
        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void setThemeValue(Context context, String key, int value) {
        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void setLanguageValue(Context context, String key, String value) {
        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static int getAppsColorValue(Context context, String key) {
        SharedPreferences pref = getPreference(context);
        int value = pref.getInt(key, APPS_DEFAULT_VALUE);
        return value;
    }

    public static int getBackgroundValue(Context context, String key) {

        SharedPreferences pref = getPreference(context);
        int value = pref.getInt(key, BACKGROUND_DFAULT_VALUE);
        return value;

    }

    public static boolean getFirstRunValue(Context context, String key) {
        SharedPreferences pref = getPreference(context);
        boolean isFirst = pref.getBoolean(key, FIRST_RUN_DEFAULT_VALUE);
        return isFirst;
    }

    public static int getFontValue(Context context, String key) {
        SharedPreferences pref = getPreference(context);
        int value = pref.getInt(key, FONT_DEFAULT_VALUE);
        return value;
    }

    public static int getButtonValue(Context context, String key) {
        SharedPreferences pref = getPreference(context);
        int value = pref.getInt(key, BUTTON_DEFAULT_VALUE);
        return value;
    }

    public static int getThemeValue(Context context, String key) {
        SharedPreferences pref = getPreference(context);
        int value = pref.getInt(key, THEME_DEFAULT_VALUE);
        return value;
    }

    public static String getLanguageValue(Context context, String key) {
        SharedPreferences pref = getPreference(context);
        String value = pref.getString(key, LANGUAGE_DEFAULT_VALUE);
        return value;
    }

    public static void removeKey(Context context, String key) {
        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor edit = pref.edit();
        edit.remove(key);
        edit.commit();
    }

    public static void clearPreferences(Context context) {
        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor edit = pref.edit();
        edit.clear();
        edit.commit();
    }



}
