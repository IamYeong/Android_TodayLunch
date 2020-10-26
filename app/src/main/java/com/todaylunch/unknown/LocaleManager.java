package com.todaylunch.unknown;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.Locale;

public class LocaleManager {

    /*
   Tip. use like right : LocaleManager.setLocale(this, "kr");

   1. SharedPreference : get or set String Language data in device.
   2. Locale : getDefault Language data.
   3. Configuration : get resource data.
   etc...


     */

    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.language";
    private static Locale locale = null;


    public static void setLocale(String lang) {

        locale = new Locale(lang);


    }


    public static Context updateResources(Context context) {



        if (locale == null) {
            return context;
        }

        final Resources res = context.getResources();
        final Configuration config = res.getConfiguration();
        config.setLocale(locale);

        return context.createConfigurationContext(config);

    }


    /*

    public static Context onAttach(Context context) {

        String language = getPersistedData(context, Locale.getDefault().getLanguage());
        return setLocale(context, language);


    }

    public static Context onAttach(Context context, String defaultLanguage) {

        String language = getPersistedData(context, defaultLanguage);
        return setLocale(context, language);

    }


     */
    //Getter fun's







}
