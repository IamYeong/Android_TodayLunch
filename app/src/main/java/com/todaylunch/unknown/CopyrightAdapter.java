package com.todaylunch.unknown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CopyrightAdapter extends RecyclerView.Adapter<CopyrightViewHolder> {

    private ArrayList<String> arrayList;
    private Context context;

    //interface
    public CopyrightAdapter(Context mContext, ArrayList<String> mArrayList) {
        this.context = mContext;
        this.arrayList = mArrayList;
    }

    @NonNull
    @Override
    public CopyrightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.textview_list, null, false);
        CopyrightViewHolder viewHolder = new CopyrightViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CopyrightViewHolder holder, int position) {

        holder.text.setText(arrayList.get(position));

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
