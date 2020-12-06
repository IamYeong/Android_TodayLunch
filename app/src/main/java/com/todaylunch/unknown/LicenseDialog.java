package com.todaylunch.unknown;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LicenseDialog {

    private Context context;
    private Dialog dialog;
    private ButtonDrawableUtil buttonUtil;
    private int buttonNumber, fontNumber;
    private Button btn_ok;
    private TextView tv_title;
    private TypefaceUtil typefaceUtil;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CopyrightAdapter adapter;
    private ArrayList<String> arrayLIst;


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
        btn_ok = dialog.findViewById(R.id.btn_license_dialog);

        addCopyrightList();

        recyclerView = (RecyclerView) dialog.findViewById(R.id.rv_license);
        layoutManager = new LinearLayoutManager(context);
        adapter = new CopyrightAdapter(context, arrayLIst);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        tv_title.setTypeface(typefaceUtil.getTypeface(fontNumber));
        btn_ok.setBackground(buttonUtil.getDrawable(buttonNumber));

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



    }

    private void addCopyrightList() {

        arrayLIst = new ArrayList<>();

        arrayLIst.add("made flaticon");
        arrayLIst.add("made fleepick");
        arrayLIst.add("dddd");


    }


}
