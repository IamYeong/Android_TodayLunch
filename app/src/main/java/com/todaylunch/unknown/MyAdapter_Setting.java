package com.todaylunch.unknown;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter_Setting extends RecyclerView.Adapter<MyViewHolder2> {

    private ArrayList<ListObject2> mArrayList;
    private Context mContext;
    private int fontNumber;
    private TypefaceUtil typefaceUtil;

    public MyAdapter_Setting() {}

    public MyAdapter_Setting(Context context, ArrayList<ListObject2> arrayList) {
        this.mArrayList = arrayList;
        this.mContext = context;
        fontNumber = MainActivity.FONT_NUMBER;
        typefaceUtil = new TypefaceUtil(context);
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_resource2, parent, false);
        MyViewHolder2 myViewHolder2 = new MyViewHolder2(view);

        return myViewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, final int position) {

        holder.imgView.setImageResource(mArrayList.get(position).getImgNumber());
        holder.tvTitle.setText(mArrayList.get(position).getTitle());

        holder.tvTitle.setTypeface(typefaceUtil.getTypeface(fontNumber));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {
                    case 0:
                        Intent intent = new Intent(mContext, DesignMenuList.class);
                        mContext.startActivity(intent);
                        break;

                    case 1:
                        //언어설정할 Dialog 구현할 것.
                        openLanguageDialog();
                        break;

                    case 2:
                        try {
                            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.todaylunch.unknown"));
                            mContext.startActivity(intent1);
                        } catch (RuntimeException e) {
                            Toast.makeText(mContext, R.string.toast_check_link, Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case 3 :
                        //개인정보정책 링크 Intent에 넣을 것.
                        Toast.makeText(mContext, R.string.toast_developing, Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (mArrayList != null ? mArrayList.size() : 0);
    }

    private void openLanguageDialog() {

        LanguageDialog dialog = new LanguageDialog(mContext);
        dialog.callDialog();
    }

}

class MyViewHolder2 extends RecyclerView.ViewHolder {

    ImageView imgView;
    TextView tvTitle;

    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);

        this.imgView = (ImageView) itemView.findViewById(R.id.img_linear_resource);
        this.tvTitle = (TextView) itemView.findViewById(R.id.tv_linear_resource);

    }
}
