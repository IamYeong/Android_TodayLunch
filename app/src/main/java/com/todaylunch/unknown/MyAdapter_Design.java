package com.todaylunch.unknown;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MyAdapter_Design extends RecyclerView.Adapter<MyViewHolder3> {

    private Context mContext;
    private ArrayList<ListObject2> mArrayList;
    //private SQLiteOpenHelperSetting dbHelper = null;
    private int fontNumber;
    private TypefaceUtil typefaceUtil;


    public MyAdapter_Design() {}

    public MyAdapter_Design(Context context, ArrayList<ListObject2> arrayList) {
        this.mContext = context;
        this.mArrayList = arrayList;

        //dbHelper = new SQLiteOpenHelperSetting(context);
        typefaceUtil = new TypefaceUtil(context);
        fontNumber = MainActivity.FONT_NUMBER;

    }

    @NonNull
    @Override
    public MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_resource2, parent, false);
        MyViewHolder3 myViewHolder3 = new MyViewHolder3(view);

        return myViewHolder3;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder3 holder, final int position) {

        holder.imgView.setImageResource(mArrayList.get(position).getImgNumber());
        holder.tvDesign.setText(mArrayList.get(position).getTitle());

        holder.tvDesign.setTypeface(typefaceUtil.getTypeface(fontNumber));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {
                    case 0 :
                        Log.d("MyAdapter_Design : ", "color picker");
                        openColorPicker(position);
                        break;

                    case 1 :
                        Log.d("MyAdapter_Design : ", "font picker");
                        openFontPickerDialog();
                        break;

                    case 2 :
                        Log.d("MyAdapter_Design", "button picker");
                        openButtonPickerDialog();
                        break;

                    case 3 :
                        Log.d("MyAdapter_Design", "background picker");
                        openColorPicker(position);
                        break;

                    case 4 :
                        Log.d("MyAdapter_Design", "Apps color picker");
                        openColorPicker(position);
                        break;


                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return (mArrayList != null ? mArrayList.size() : 0);
    }

    public void openButtonPickerDialog() {

        ButtonPickerDialog buttonPickerDialog = new ButtonPickerDialog(mContext);
        buttonPickerDialog.callDialog();


    }

    public void openFontPickerDialog() {

        fontDialog dialog = new fontDialog(mContext);
        dialog.callDialog();
        //dialog builder 예정

    }


    public void openColorPicker(final int mPosition) {

        Activity activity = (Activity) mContext;

        final ColorPicker cp = new ColorPicker(activity);
        String title = mContext.getResources().getString(R.string.colorpicker);
        cp.setTitle(title);

        final ArrayList<String> colors = new ArrayList<>();

        colors.add("#87C6F1");
        colors.add("#66B3E8");
        colors.add("#EFB8E4");
        colors.add("#D4B3E2");
        colors.add("#8EAEDF");

        colors.add("#FCD8DF");
        colors.add("#EF889A");
        colors.add("#EDAFC4");
        colors.add("#935887");
        colors.add("#8A7FAE");

        colors.add("#CBC5C1");
        colors.add("#A2AAB0");
        colors.add("#EBECED");
        colors.add("#4C586F");
        colors.add("#3E3E3B");

        colors.add("#DAE9E4");
        colors.add("#8BCBC8");
        colors.add("#ECC7C0");
        colors.add("#FDAE84");
        colors.add("#3C2E3D");

        colors.add("#4BBCF4");
        colors.add("#61C0BF");
        colors.add("#BBDED6");
        colors.add("#FFB6B9");
        colors.add("#FAE3D9");

        colors.add("#EDFAFD");
        colors.add("#AED9DA");
        colors.add("#3DDAD7");
        colors.add("#2A93D5");
        colors.add("#135589");


        cp.setColors(colors)
                .setColumns(5)
                .setRoundColorButton(true)
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {


                        Log.d("colors string list : ", colors.get(position) + ", " + color);

                        if (mPosition == 0) {
                            PreferencesManager.setThemeValue(mContext, "THEME", color);
                        } else if(mPosition == 3) {
                            PreferencesManager.setBackgroundValue(mContext, "BACKGROUND", color);
                        } else {
                            PreferencesManager.setAppsColorValue(mContext, "APPS", color);
                        }



                        cp.dismissDialog();

                        ((Activity) mContext).finishAffinity();
                        Intent intent = new Intent(mContext, MainActivity.class);
                        mContext.startActivity(intent);

                    }

                    @Override
                    public void onCancel() {
                        cp.dismissDialog();
                        Toast.makeText(mContext, R.string.toast_cancel, Toast.LENGTH_SHORT).show();
                    }

                }).show();

    }


}

class MyViewHolder3 extends RecyclerView.ViewHolder {

    ImageView imgView;
    TextView tvDesign;

    public MyViewHolder3(@NonNull View itemView) {
        super(itemView);

        this.imgView = itemView.findViewById(R.id.img_linear_resource);
        this.tvDesign = itemView.findViewById(R.id.tv_linear_resource);


    }
}
