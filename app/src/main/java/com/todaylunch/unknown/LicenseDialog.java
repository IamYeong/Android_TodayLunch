package com.todaylunch.unknown;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class LicenseDialog {

    public Context context;
    public Dialog dialog;
    private ButtonDrawableUtil buttonUtil;
    public int buttonNumber, fontNumber;
    public Button btn_ok;
    protected TextView tv_title, tv_license;
    public TypefaceUtil typefaceUtil;

    public LicenseDialog(Context context) {
        this.context = context;
        buttonUtil = new ButtonDrawableUtil(context);
        typefaceUtil = new TypefaceUtil(context);
        buttonNumber = MainActivity.BACKGROUND_NUMBER;
        fontNumber = MainActivity.FONT_NUMBER;
    }

    public void callLicenseDialog() {

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.license_dialog);
        dialog.show();

        tv_title = dialog.findViewById(R.id.tv_license_title);
        tv_license = dialog.findViewById(R.id.tv_license);
        btn_ok = dialog.findViewById(R.id.btn_license_dialog);

        tv_license.setText(
                "License"

        );

        tv_title.setTypeface(typefaceUtil.getTypeface(fontNumber));
        tv_license.setTypeface(typefaceUtil.getTypeface(fontNumber));
        btn_ok.setBackground(buttonUtil.getDrawable(buttonNumber));

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



    }


}
