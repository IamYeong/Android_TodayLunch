package com.todaylunch.unknown;

import android.app.Dialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class CustomDialog implements DialogClickListener {

    private Context context;
    private ArrayList<Integer> arrayList;
    private Dialog dialog;


    public CustomDialog(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    public void showCustomDialog() {

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.show();

        Button btn_cancel = (Button) dialog.findViewById(R.id.btn_dialog_cancel);
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.rv_dialog);
        DialogAdapter dialogAdapter = new DialogAdapter(context, arrayList);
        dialogAdapter.setDialogListener(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(dialogAdapter);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }


    @Override
    public void onDialogClickListener() {

        dialog.dismiss();
    }
}
