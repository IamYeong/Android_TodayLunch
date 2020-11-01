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
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom3));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom4));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom5));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom6));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom7));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom8));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom9));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom10));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom11));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom12));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom13));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom14));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom15));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom16));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom17));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom18));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom19));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom20));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom21));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom22));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom23));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom24));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom25));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom26));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom27));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom28));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom29));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom30));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom31));
        arrayList.add(context.getResources().getDrawable(R.drawable.button_custom32));

    }

    //btn.setBackground(Drawable)

    public Drawable getDrawable(int n) {

        return arrayList.get(n);

    }

}
