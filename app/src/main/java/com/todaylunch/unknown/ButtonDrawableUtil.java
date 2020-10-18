package com.todaylunch.unknown;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class ButtonDrawableUtil {

    private Context context;
    private ArrayList<Drawable> arrayList;

    public ButtonDrawableUtil(Context context) {

        this.context = context;
        arrayList = new ArrayList<>();

        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom1));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom2));

    }

    //btn.setBackground(Drawable)

    public Drawable getDrawable(int n) {

        return arrayList.get(n);

    }

}
