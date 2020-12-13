package com.todaylunch.unknown;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ButtonPickerDialog implements DialogClickListener {

    private Context context;
    private int buttonNumber, fontNumber;
    private TypefaceUtil typefaceUtil;
    private TextView tvTitle;
    private Dialog dialog;

    public ButtonPickerDialog() {}

    public ButtonPickerDialog(Context context) {

        this.context = context;
        buttonNumber = MainActivity.BACKGROUND_NUMBER;
        fontNumber = MainActivity.FONT_NUMBER;
        typefaceUtil = new TypefaceUtil(context);

    }

    public void callDialog() {

        //fontDialog layout 사용하고 어댑터 리소스도 list_resource2 사용하면 됨.
        //해당 layout 에 사용되는 버튼에 각각 setDrawable 한 후 position값을 db에 저장시키면 끝.

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        View view = LayoutInflater.from(context).inflate(R.layout.button_dialog_layout, null, false);

        dialog.setContentView(view);

        tvTitle = view.findViewById(R.id.tv_button_dialog);
        tvTitle.setText(context.getResources().getString(R.string.button));
        tvTitle.setTypeface(typefaceUtil.getTypeface(fontNumber));

        RecyclerView rv = (RecyclerView) dialog.findViewById(R.id.rv_button_dialog);
        LinearLayoutManager lm = new LinearLayoutManager(context);
        ButtonAdapter adapter = new ButtonAdapter(context);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        adapter.setCustomListener(this);

        dialog.show();


    }


    @Override
    public void onDialogClickListener() {
        dialog.dismiss();
    }
}
