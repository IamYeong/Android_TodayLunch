package com.todaylunch.unknown;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LanguageDialogAdapter extends RecyclerView.Adapter<LanguageViewHolder> {

    private Context context;
    private ArrayList<String> arrayList;
    private DialogClickListener listener;

    public LanguageDialogAdapter(Context context) {

        this.context = context;
        arrayList = new ArrayList<>();

        arrayList.add("English");
        arrayList.add("한국어");
        arrayList.add("일본어");
    }

    public void customFontClickListener(DialogClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.checkbox_list_source, null, false);
        LanguageViewHolder viewHolder = new LanguageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, final int position) {

        holder.btn.setText(arrayList.get(position));

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {

                    case 0 :

                        //언어변경 코드
                        PreferencesManager.setLanguageValue(context, "LANGUAGE", "en");

                        Toast.makeText(context, "영어", Toast.LENGTH_SHORT).show();
                        listener.onDialogClickListener();

                        ((Activity) context).finishAffinity();
                        Intent intent1 = new Intent(context, SplashActivity.class);
                        context.startActivity(intent1);

                        break;

                    case 1 :


                        PreferencesManager.setLanguageValue(context, "LANGUAGE", "ko");

                        Toast.makeText(context, "한국어", Toast.LENGTH_SHORT).show();
                        listener.onDialogClickListener();

                        ((Activity) context).finishAffinity();
                        Intent intent2 = new Intent(context, SplashActivity.class);
                        context.startActivity(intent2);

                        break;

                    case 2 :

                        PreferencesManager.setLanguageValue(context, "LANGUAGE", "ja");

                        Toast.makeText(context, "일본어", Toast.LENGTH_SHORT).show();
                        listener.onDialogClickListener();

                        ((Activity) context).finishAffinity();
                        Intent intent3 = new Intent(context, SplashActivity.class);
                        context.startActivity(intent3);

                        break;

                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }
}

class LanguageViewHolder extends RecyclerView.ViewHolder {

    Button btn;

    public LanguageViewHolder(@NonNull View itemView) {
        super(itemView);

        btn = itemView.findViewById(R.id.btn_font_check);


    }
}