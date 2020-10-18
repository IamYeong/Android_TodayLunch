package com.todaylunch.unknown;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

public class CustomProgressDialog {

    Context context;
    View dialogView;
    AlertDialog.Builder builder;
    AlertDialog dialog;

    public CustomProgressDialog() {}

    public CustomProgressDialog(Context context) {

        this.context = context;
        dialogView = LayoutInflater.from(context).inflate(R.layout.progress_dialog, null, false);
        builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setView(dialogView);
        dialog = builder.create();

    }

    public void setProgressDialog() {
        dialog.show();
    }

    public void offProgressDialog() {
        dialog.dismiss();

    }


}
