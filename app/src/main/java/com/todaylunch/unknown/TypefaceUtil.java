package com.todaylunch.unknown;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import androidx.core.content.res.ResourcesCompat;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class TypefaceUtil {

    public ArrayList<Typeface> typefaceArrayList = new ArrayList<>();
    Context context;

    public TypefaceUtil(Context context) {

        this.context = context;

        Typeface typeface1 = ResourcesCompat.getFont(context, R.font.bmdohyeon);
        Typeface typeface2 = ResourcesCompat.getFont(context, R.font.bmeuljiro);
        Typeface typeface3 = ResourcesCompat.getFont(context, R.font.bmhannaair);
        Typeface typeface4 = ResourcesCompat.getFont(context, R.font.bmhannaeleven);
        Typeface typeface5 = ResourcesCompat.getFont(context, R.font.bmhannapro);
        Typeface typeface6 = ResourcesCompat.getFont(context, R.font.bmjua);

        typefaceArrayList.add(typeface1);
        typefaceArrayList.add(typeface2);
        typefaceArrayList.add(typeface3);
        typefaceArrayList.add(typeface4);
        typefaceArrayList.add(typeface5);
        typefaceArrayList.add(typeface6);

    }

    public Typeface getTypeface(int fontNumber) {
        return typefaceArrayList.get(fontNumber);
    }


}
