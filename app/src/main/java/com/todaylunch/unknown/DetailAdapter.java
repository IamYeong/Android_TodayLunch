package com.todaylunch.unknown;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailViewHolder> {

    Context context;
    ArrayList<ListObject3> arrayList;
    int clickNumber;
    String clickTitle;
    TypefaceUtil typefaceUtil;
    int typefaceNumber;


    public DetailAdapter() {
    }
    public DetailAdapter(Context context, ArrayList<ListObject3> arrayList, int clickNumber, String clickTitle) {

        this.context = context;
        this.arrayList = arrayList;
        this.clickNumber = clickNumber;
        this.clickTitle = clickTitle;
        typefaceUtil = new TypefaceUtil(context);
        typefaceNumber = MainActivity.FONT_NUMBER;

    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fragment1_grid_resource, parent, false);
        DetailViewHolder viewHolder = new DetailViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, final int position) {

        final String mTitle = arrayList.get(position).getmTitle();

        holder.imageView.setImageResource(arrayList.get(position).getmImgNum());
        holder.textView.setTypeface(typefaceUtil.getTypeface(typefaceNumber));
        holder.textView.setText(mTitle);
        holder.cardView.setCardBackgroundColor(MainActivity.APPS_COLOR_NUMBER);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MyMenuList.class);
                intent.putExtra("ClickNumber", (clickNumber * 9) + (position + 1));
                intent.putExtra("title", clickTitle);
                intent.putExtra("title2", mTitle);

                //1~9 * 1~9
                //(clickNumber * 9) - 9 + (position + 1)
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }
}

class DetailViewHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    ImageView imageView;
    TextView textView;

    public DetailViewHolder(@NonNull View itemView) {
        super(itemView);

        this.cardView = itemView.findViewById(R.id.cardView_fragment1);
        this.imageView = itemView.findViewById(R.id.img_fragment1_grid);
        this.textView = itemView.findViewById(R.id.tv_fragment1_grid);

    }
}
