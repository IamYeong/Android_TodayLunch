package com.todaylunch.unknown;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdjustAdapter extends RecyclerView.Adapter<AdjustViewHolder> {

    Context context;
    ArrayList<ListObject3> arrayList;


    public AdjustAdapter() {
    }

    public AdjustAdapter(Context context, ArrayList<ListObject3> arrayList) {

        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public AdjustViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adjust_grid_resource_edit, parent, false);
        AdjustViewHolder viewHolder = new AdjustViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdjustViewHolder holder, final int position) {

        holder.imageView.setImageResource(arrayList.get(position).getmImgNum());
        holder.editText.setText(arrayList.get(position).getmTitle());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuAdjust.CLICK_NUMBER = position;
                CustomDialog dialog = new CustomDialog(context, MainActivity.IMAGE_ID_ARRAYLIST);
                dialog.showCustomDialog();
            }
        });

        holder.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String et = holder.editText.getText().toString();
                arrayList.get(position).setmTitle(et);
                Toast.makeText(context, "holder EditText : " + et, Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }
}

class AdjustViewHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    ImageView imageView;
    EditText editText;
    Button btnConfirm;

    public AdjustViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView = (CardView) itemView.findViewById(R.id.cardView_adjust_edit);
        imageView = (ImageView) itemView.findViewById(R.id.img_adjust_grid);
        editText = (EditText) itemView.findViewById(R.id.et_adjust_grid);
        btnConfirm = (Button) itemView.findViewById(R.id.btn_adjust_grid);

    }
}