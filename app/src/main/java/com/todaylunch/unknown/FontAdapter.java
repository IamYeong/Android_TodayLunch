package com.todaylunch.unknown;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FontAdapter extends RecyclerView.Adapter<FontViewHolder> {

    Context context;
    ArrayList<String> arrayList = new ArrayList<>();
    private TypefaceUtil typefaceUtil;
    private SQLiteOpenHelperSetting dbHelper = null;
    private DialogClickListener listener;


    public FontAdapter(Context context) {
        this.context = context;

        String list1 = context.getResources().getString(R.string.bmdohyeon);
        String list2 = context.getResources().getString(R.string.bmeuljiro);
        String list3 = context.getResources().getString(R.string.bmhannaair);
        String list4 = context.getResources().getString(R.string.bmhannaeleven);
        String list5 = context.getResources().getString(R.string.bmhannapro);
        String list6 = context.getResources().getString(R.string.bmjua);


        arrayList.add(list1);
        arrayList.add(list2);
        arrayList.add(list3);
        arrayList.add(list4);
        arrayList.add(list5);
        arrayList.add(list6);

        typefaceUtil = new TypefaceUtil(context);
        dbHelper = new SQLiteOpenHelperSetting(context);


    }

    public void customFontClickListener(DialogClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public FontViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.checkbox_list_source, null , false);
        FontViewHolder holder = new FontViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final FontViewHolder holder, final int position) {

        holder.btn.setText(arrayList.get(position));
        holder.btn.setTypeface(typefaceUtil.getTypeface(position));

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String update = MySQLite.SQL_UPDATE3 + MySQLite.DCOL_NAME4 + " = " + position;
                db.execSQL(update);
                db.close();
                 */

                PreferencesManager.setFontValue(context, "FONT", position);

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

class FontViewHolder extends RecyclerView.ViewHolder {

    Button btn;

    public FontViewHolder(@NonNull View itemView) {

        super(itemView);

        btn = (Button) itemView.findViewById(R.id.btn_font_check);

    }
}