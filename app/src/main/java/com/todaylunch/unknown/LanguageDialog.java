package com.todaylunch.unknown;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LanguageDialog implements DialogClickListener {

    private Context context;
    private TextView tvTitle;
    private TypefaceUtil typefaceUtil;
    private int fontNumber;
    private Dialog dialog;

    public LanguageDialog() {}

    public LanguageDialog(Context context) {
        this.context = context;
        fontNumber = MainActivity.FONT_NUMBER;
        typefaceUtil = new TypefaceUtil(context);
    }

    public void callDialog() {

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        View view = LayoutInflater.from(context).inflate(R.layout.font_dialog_layout, null, false);

        dialog.setContentView(view);

        tvTitle = view.findViewById(R.id.tv_font_dialog_title);
        tvTitle.setText("언어설정");
        tvTitle.setTypeface(typefaceUtil.getTypeface(fontNumber));

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_font_dialog);
        LinearLayoutManager lm = new LinearLayoutManager(context);
        LanguageDialogAdapter adapter = new LanguageDialogAdapter(context);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);


        adapter.customFontClickListener(this);

        dialog.show();

    }

    @Override
    public void onDialogClickListener() {
        dialog.dismiss();
    }
}
