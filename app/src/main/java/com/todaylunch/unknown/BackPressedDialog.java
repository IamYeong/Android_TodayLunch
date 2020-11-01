package com.todaylunch.unknown;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class BackPressedDialog {

    public Context context;
    public Dialog dialog;
    private ButtonDrawableUtil buttonUtil;
    public int buttonNumber, fontNumber;
    public Button btn_ok, btn_cancel;
    private TextView tv_title;
    private TypefaceUtil typefaceUtil;


    public BackPressedDialog(Context context) {
        this.context = context;
        buttonUtil = new ButtonDrawableUtil(context);
        typefaceUtil = new TypefaceUtil(context);
        buttonNumber = MainActivity.BACKGROUND_NUMBER;
        fontNumber = MainActivity.FONT_NUMBER;

    }

    public void callBackPressDialog() {

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.backpressed_dialog);
        dialog.show();

        btn_ok = dialog.findViewById(R.id.btn_backpressed_positive);
        btn_cancel = dialog.findViewById(R.id.btn_backpressed_negative);
        tv_title = dialog.findViewById(R.id.tv_backpress);

        btn_ok.setBackground(buttonUtil.getDrawable(buttonNumber));
        btn_cancel.setBackground(buttonUtil.getDrawable(buttonNumber));
        tv_title.setTypeface(typefaceUtil.getTypeface(fontNumber));

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ((Activity) context ).finish();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

}
