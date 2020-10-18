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



public class CustomDialog {

    private Context context;
    private ArrayList<Integer> arrayList;


    public CustomDialog(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    public void showCustomDialog() {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.show();

        Button btn_confirm = (Button) dialog.findViewById(R.id.btn_dialog_confirm);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btn_dialog_cancel);
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.rv_dialog);
        DialogAdapter dialogAdapter = new DialogAdapter(context, arrayList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(dialogAdapter);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                AdjustAdapter adapter = new AdjustAdapter();
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

    }





}
