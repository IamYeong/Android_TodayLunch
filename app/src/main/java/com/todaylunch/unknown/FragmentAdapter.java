package com.todaylunch.unknown;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class FragmentAdapter extends RecyclerView.Adapter<FragmentViewHolder> {

    Context context;
    ArrayList<ListObject3> arrayList;
    TypefaceUtil typefaceUtil;
    int typefaceNumber;

    public FragmentAdapter() {    }
    public FragmentAdapter(Context context, ArrayList<ListObject3> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
        typefaceUtil = new TypefaceUtil(context);
        typefaceNumber = MainActivity.FONT_NUMBER;

    }

    @NonNull
    @Override
    public FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment1_grid_resource, parent, false);
        FragmentViewHolder viewHolder = new FragmentViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final FragmentViewHolder holder, final int position) {

        //카드뷰 속성 매칭 시켜야 함.
        final String title = arrayList.get(position).getmTitle();
        holder.imageView.setImageResource(arrayList.get(position).getmImgNum());
        holder.textView.setTypeface(typefaceUtil.getTypeface(typefaceNumber));
        holder.textView.setText(title);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MenuDetail.class);
                intent.putExtra("Click", position + 1);
                intent.putExtra("title", title);
                System.out.println(position+1);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return (arrayList != null? arrayList.size() : 0);
    }
}

class FragmentViewHolder extends RecyclerView.ViewHolder{

    CardView cardView;
    ImageView imageView;
    TextView textView;


    public FragmentViewHolder(@NonNull View itemView) {

        super(itemView);

        this.cardView = itemView.findViewById(R.id.cardView_fragment1);
        this.imageView = itemView.findViewById(R.id.img_fragment1_grid);
        this.textView = itemView.findViewById(R.id.tv_fragment1_grid);

    }
}