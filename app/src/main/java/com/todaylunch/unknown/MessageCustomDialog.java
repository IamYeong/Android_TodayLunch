package com.todaylunch.unknown;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MessageCustomDialog {


    private ButtonDrawableUtil buttonUtil;
    private int buttonNumber, fontNumber;
    private TextView tv_title;
    private TypefaceUtil typefaceUtil;

    //object interface
    public Button btn_ok_msg_dialog, btn_cancel_msg_dialog;
    public Dialog msgDialogVar;

    public MessageCustomDialog(Context context, String titleValue) {
        buttonUtil = new ButtonDrawableUtil(context);
        typefaceUtil = new TypefaceUtil(context);

        buttonNumber = MainActivity.BACKGROUND_NUMBER;
        fontNumber = MainActivity.FONT_NUMBER;

        msgDialogVar = new Dialog(context);
        msgDialogVar.requestWindowFeature(Window.FEATURE_NO_TITLE);
        msgDialogVar.setContentView(R.layout.message_custom_dialog);

        btn_ok_msg_dialog = msgDialogVar.findViewById(R.id.btn_msg_custom_positive);
        btn_cancel_msg_dialog = msgDialogVar.findViewById(R.id.btn_msg_custom_negative);
        tv_title = msgDialogVar.findViewById(R.id.tv_message_custom_dialog);

        btn_ok_msg_dialog.setBackground(buttonUtil.getDrawable(buttonNumber));
        btn_cancel_msg_dialog.setBackground(buttonUtil.getDrawable(buttonNumber));
        tv_title.setTypeface(typefaceUtil.getTypeface(fontNumber));
        tv_title.setText(titleValue);

        msgDialogVar.show();

    }

    //implementation


}
