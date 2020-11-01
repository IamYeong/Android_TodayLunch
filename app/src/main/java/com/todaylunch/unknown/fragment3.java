package com.todaylunch.unknown;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class fragment3 extends Fragment {

    private Button button_start;
    private FrameLayout frameLayout;
    private FrameLayout backgroundFrameLayout;
    private SQLiteOpenHelperMain dbHelper;
    private ArrayList<String> arrayList;
    private TextView tvRandom;
    private Animation frame_open, frame_close;
    private TypefaceUtil typefaceUtil;
    private int fontNumber, btnNumber;

    private ButtonDrawableUtil btnUtil;

    private CustomProgressDialog customProgressDialog;


    public fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);

        customProgressDialog = new CustomProgressDialog(getContext());
        customProgressDialog.setProgressDialog();

        init(view);

        typefaceUtil = new TypefaceUtil(getContext());
        btnUtil = new ButtonDrawableUtil(getContext());
        fontNumber = MainActivity.FONT_NUMBER;
        btnNumber = MainActivity.BACKGROUND_NUMBER;

        tvRandom.setTypeface(typefaceUtil.getTypeface(fontNumber));
        button_start.setBackground(btnUtil.getDrawable(btnNumber));

        backgroundFrameLayout.setBackgroundColor(MainActivity.FRAMELAYOUT_NUMBER);

        init_value();
        load_value();

        customProgressDialog.offProgressDialog();

        frameLayout.startAnimation(frame_close);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //시작버튼 클릭하면 메뉴 데이터 중 랜덤으로 선정.

                frameLayout.startAnimation(frame_open);

                //START ADD!!!!!!


                if (arrayList.size() == 0) {
                    Toast.makeText(getActivity(), R.string.toast_check_list, Toast.LENGTH_SHORT).show();
                } else {
                    Random random = new Random();
                    int n = random.nextInt(arrayList.size());
                    String strRandom = arrayList.get(n);
                    tvRandom.setText(strRandom);
                }

                frameLayout.startAnimation(frame_close);

            }
        });

        return view;

    }

    private void init_value() {
        dbHelper = new SQLiteOpenHelperMain(getActivity());
    }

    private void load_value() {
        //db를 arrayList에 할당

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT, null);

        cursor.moveToFirst();

        if (cursor.getCount() == 0) {

        } else {

            for(int i = 0; i < cursor.getCount(); i++) {

                String strCursor = cursor.getString(3);
                arrayList.add(strCursor);
                cursor.moveToNext();
            }
            cursor.close();
        }

        cursor.close();
        db.close();

    }

    private void init(View view) {

        arrayList = new ArrayList<>();

        tvRandom = (TextView) view.findViewById(R.id.tvRandom);
        frameLayout = view.findViewById(R.id.frg3_frame);

        frame_open = AnimationUtils.loadAnimation(getContext(), R.anim.frame_opacity);
        frame_close = AnimationUtils.loadAnimation(getContext(), R.anim.frame_opacity_reverse);

        button_start = (Button) view.findViewById(R.id.btn_start);

        backgroundFrameLayout = view.findViewById(R.id.frame_fragment3);
    }

}
