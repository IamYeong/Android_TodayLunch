package com.todaylunch.unknown;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.logging.LogRecord;

public class CustomProgressDialog {

    private Context context;
    private Dialog dialog;
    private int maxCount;
    private ProgressBar progressBar;
    private TextView textViewPercent;


    public CustomProgressDialog() {}

    public CustomProgressDialog(Context mContext) {

        this.context = mContext;
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.backpressed_dialog);

        progressBar = dialog.findViewById(R.id.progress_bar);
        textViewPercent = dialog.findViewById(R.id.tv_loading_percent);


        dialog.show();


    }

    public void setProgrssCount(int number) {

        int resultNumber = (number / maxCount) * 100;
        String stringResult = Integer.toString(resultNumber);
        textViewPercent.setText(stringResult);

    }

    private void setProgressBar() {

    }




}
