package com.todaylunch.unknown;


import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;

public class CustomProgressDialog extends Dialog {

    protected ProgressBar progressBar;

    public CustomProgressDialog(@NonNull Context context) {
        super(context);
    }

    public void settingCustomProgressDialog() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.progress_dialog);

        progressBar = findViewById(R.id.progress_bar);

        setCancelable(false);

        show();

    }

    public void setProgressCount(int number) {

        /*
        counting = number;
        int resultNumber = (counting / maxCount) * 100;
        String strResult = Integer.toString(resultNumber);
        textViewPercent.setText(strResult);

         */
    }

    public void setProgressBar(int maxNumber) {

        //progressBar.setMax(maxNumber);
    }

}
