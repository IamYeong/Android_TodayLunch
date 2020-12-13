package com.todaylunch.unknown;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
    private Button btn_ok;
    private TextView tv_title;
    private TypefaceUtil typefaceUtil;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CopyrightAdapter adapter;
    private ArrayList<CopyrightInfo> arrayLIst;
    private Drawable drawable;
    private Typeface typeface;


    public LicenseDialog(Context context) {
        this.context = context;
        buttonUtil = new ButtonDrawableUtil(context);
        typefaceUtil = new TypefaceUtil(context);
        drawable = buttonUtil.getDrawable(MainActivity.BACKGROUND_NUMBER);
        typeface = typefaceUtil.getTypeface(MainActivity.FONT_NUMBER);

        addCopyrightList();
    }

    public void callLicenseDialog() {

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.license_dialog);

        dialog.show();

        tv_title = (TextView) dialog.findViewById(R.id.tv_license_title);
        btn_ok = (Button) dialog.findViewById(R.id.btn_license_dialog);

        recyclerView = (RecyclerView) dialog.findViewById(R.id.rv_license);
        layoutManager = new LinearLayoutManager(context);
        adapter = new CopyrightAdapter(context, arrayLIst);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        tv_title.setTypeface(typeface);
        btn_ok.setBackground(drawable);
        //btn_ok.setText(context.getResources().getString(R.string.toast_confirm));


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }

    private void addCopyrightList() {

        arrayLIst = new ArrayList<>();



        arrayLIst.add(new CopyrightInfo(
                "Icons made by Freepik from www.flaticon.com",
                "Freepik",
                "http://www.freepik.com/",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


        arrayLIst.add(new CopyrightInfo("Icons made by Flat Icons from www.flaticon.com",
                "Flat",
                "https://flat-icons.com/",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


        arrayLIst.add(new CopyrightInfo("Icons made by Eucalyp from www.flaticon.com",
                "Eucalyp",
                "https://www.flaticon.com/authors/eucalyp",
                "www.flaticon.com",
                "https://www.flaticon.com/"));

        arrayLIst.add(new CopyrightInfo("Icons made by Adib Sulthon from www.flaticon.com",
                "Adib Sulthon",
                "https://www.flaticon.com/free-icon/meat_1134447?term=food&page=5&position=33",
                "www.flaticon.com",
                "https://www.flaticon.com/"));

        arrayLIst.add(new CopyrightInfo("Icons made by mangsaabguru from www.flaticon.com",
                "mangsaabguru",
                "https://www.flaticon.com/free-icon/chinese-food_3447845?term=food&page=6&position=90",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


        arrayLIst.add(new CopyrightInfo("Icons made by iconixar from www.flaticon.com",
                "iconixar",
                "https://www.flaticon.com/authors/iconixar",
                "www.flaticon.com",
                "https://www.flaticon.com/"));

        arrayLIst.add(new CopyrightInfo("Icons made by mynamepong from www.flaticon.com",
                "mynamepong",
                "https://www.flaticon.com/authors/mynamepong",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


        arrayLIst.add(new CopyrightInfo("Icons made by smalllikeart from www.flaticon.com",
                "smalllikeart",
                "https://www.flaticon.com/authors/smalllikeart",
                "www.flaticon.com",
                "https://www.flaticon.com/"));

        arrayLIst.add(new CopyrightInfo("Icons made by photo3idea_studio from www.flaticon.com",
                "photo3idea_studio",
                "https://www.flaticon.com/authors/photo3idea-studio",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


        arrayLIst.add(new CopyrightInfo("Icons made by pongsakornRed from www.flaticon.com",
                "pongsakornRed",
                "https://www.flaticon.com/authors/pongsakornred",
                "www.flaticon.com",
                "https://www.flaticon.com/"));

        arrayLIst.add(new CopyrightInfo("Icons made by monkik from www.flaticon.com",
                "monkik",
                "https://www.flaticon.com/authors/monkik",
                "www.flaticon.com",
                "https://www.flaticon.com/"));



        arrayLIst.add(new CopyrightInfo("Icons made by surang from www.flaticon.com",
                "surang",
                "https://www.flaticon.com/free-icon/pad-thai_2943064?term=noodle&page=1&position=45",
                "www.flaticon.com",
                "https://www.flaticon.com/"));

        arrayLIst.add(new CopyrightInfo("Icons made by ultimatearm from www.flaticon.com",
                "ultimatearm",
                "https://www.flaticon.com/authors/ultimatearm",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


        arrayLIst.add(new CopyrightInfo("Icons made by Darius Dan from www.flaticon.com",
                "Darius Dan",
                "https://www.flaticon.com/authors/darius-dan",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


        arrayLIst.add(new CopyrightInfo("Icons made by Roundicons from www.flaticon.com",
                "Roundicons",
                "https://roundicons.com/",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


        arrayLIst.add(new CopyrightInfo("Icons made by Pause08 from www.flaticon.com",
                "Pause08",
                "https://www.flaticon.com/free-icon/taco_1357295",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


        arrayLIst.add(new CopyrightInfo("Icons made by Smashicons from www.flaticon.com",
                "Smashicons",
                "https://www.flaticon.com/authors/smashicons",
                "www.flaticon.com",
                "https://www.flaticon.com/"));


    }


}
