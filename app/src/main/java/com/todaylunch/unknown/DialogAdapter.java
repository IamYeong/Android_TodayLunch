package com.todaylunch.unknown;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DialogAdapter extends RecyclerView.Adapter<DialogViewHolder> {

    ArrayList<Integer> mArrayList;
    Context context;
    private AdapterClickListener listener;
    private DialogClickListener clickListener;



    public DialogAdapter() {}

    public DialogAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.mArrayList = arrayList;

    }

    public void setDialogListener(DialogClickListener listener) {
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public DialogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
        DialogViewHolder viewHolder = new DialogViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DialogViewHolder holder, final int position) {

        holder.imageView.setImageResource(mArrayList.get(position));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imageResourceId = mArrayList.get(position);

                Log.d("Image Id set", "Image Id : " + imageResourceId);

                listener = (AdapterClickListener) context;
                listener.onGridItemClickListener(imageResourceId);

                clickListener.onDialogClickListener();

            }
        });

    }

    @Override
    public int getItemCount() {
        return (mArrayList != null ? mArrayList.size() : 0);
    }
}

class DialogViewHolder extends RecyclerView.ViewHolder {

    protected ImageView imageView;

    public DialogViewHolder(@NonNull View itemView) {
        super(itemView);

        this.imageView = itemView.findViewById(R.id.img_dialog);

    }
}
