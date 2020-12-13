package com.todaylunch.unknown;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonViewHolder> {

    private ArrayList<String> arrayList;
    private Context context;
    protected ButtonDrawableUtil btnUtil;
    protected int btnNumber;
    //private SQLiteOpenHelperSetting dbHelper;
    private DialogClickListener listener;

    public ButtonAdapter(Context context) {

        this.context = context;
        btnNumber = MainActivity.BACKGROUND_NUMBER;
        btnUtil = new ButtonDrawableUtil(context);

        arrayList = new ArrayList<>();
        arrayList.add("Style1");
        arrayList.add("Style2");
        arrayList.add("Style3");
        arrayList.add("Style4");
        arrayList.add("Style5");
        arrayList.add("Style6");
        arrayList.add("Style7");
        arrayList.add("Style8");
        arrayList.add("Style9");
        arrayList.add("Style10");
        arrayList.add("Style11");
        arrayList.add("Style12");
        arrayList.add("Style13");
        arrayList.add("Style14");
        arrayList.add("Style15");
        arrayList.add("Style16");
        arrayList.add("Style17");
        arrayList.add("Style18");
        arrayList.add("Style19");
        arrayList.add("Style20");
        arrayList.add("Style21");
        arrayList.add("Style22");
        arrayList.add("Style23");
        arrayList.add("Style24");
        arrayList.add("Style25");
        arrayList.add("Style26");
        arrayList.add("Style27");
        arrayList.add("Style28");
        arrayList.add("Style29");
        arrayList.add("Style30");
        arrayList.add("Style31");
        arrayList.add("Style32");

        //dbHelper = new SQLiteOpenHelperSetting(context);


    }

    public void setCustomListener(DialogClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.checkbox_list_source , parent, false);
        ButtonViewHolder viewHolder = new ButtonViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, final int position) {

        holder.btn.setText(arrayList.get(position));
        holder.btn.setBackground(btnUtil.getDrawable(position));

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferencesManager.setButtonValue(context, "BUTTON", position);

                listener.onDialogClickListener();

                ((Activity) context).finishAffinity();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }
}

class ButtonViewHolder extends RecyclerView.ViewHolder {

    Button btn;

    public ButtonViewHolder(@NonNull View itemView) {
        super(itemView);

        btn = itemView.findViewById(R.id.btn_font_check);

    }
}
