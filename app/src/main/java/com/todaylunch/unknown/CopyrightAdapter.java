package com.todaylunch.unknown;

import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyrightAdapter extends RecyclerView.Adapter<CopyrightViewHolder> {

    private ArrayList<CopyrightInfo> arrayList;
    private Context context;

    //interface
    public CopyrightAdapter(Context mContext, ArrayList<CopyrightInfo> mArrayList) {
        this.context = mContext;
        this.arrayList = mArrayList;
    }

    @NonNull
    @Override
    public CopyrightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.textview_list, parent, false);
        CopyrightViewHolder viewHolder = new CopyrightViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CopyrightViewHolder holder, int position) {

        arrayList.get(position).setLink(context, holder.text);

    }

    @Override
    public int getItemCount() {
        return (arrayList != null? arrayList.size() : 0);
    }
}

class CopyrightViewHolder extends RecyclerView.ViewHolder {

    TextView text;

    public CopyrightViewHolder(@NonNull View itemView) {
        super(itemView);

        this.text = itemView.findViewById(R.id.tv_textview_list);


    }
}
