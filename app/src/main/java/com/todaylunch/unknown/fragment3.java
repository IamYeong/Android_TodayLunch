package com.todaylunch.unknown;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

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

    private InterstitialAd interstitialAd;
    //app id : ca-app-pub-8489601855107344~4865112043
    //test ad id : ca-app-pub-3940256099942544/1033173712
    //ad id : ca-app-pub-8489601855107344/4953398494


    public fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);



        init(view);
        loadInterstitialAd();


        typefaceUtil = new TypefaceUtil(getContext());
        btnUtil = new ButtonDrawableUtil(getContext());
        fontNumber = MainActivity.FONT_NUMBER;
        btnNumber = MainActivity.BACKGROUND_NUMBER;

        tvRandom.setTypeface(typefaceUtil.getTypeface(fontNumber));
        button_start.setBackground(btnUtil.getDrawable(btnNumber));

        backgroundFrameLayout.setBackgroundColor(MainActivity.FRAMELAYOUT_NUMBER);

        init_value();
        load_value();

        final Random random = new Random();

        frameLayout.startAnimation(frame_close);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //시작버튼 클릭하면 메뉴 데이터 중 랜덤으로 선정.

                frameLayout.startAnimation(frame_open);

                int randomNumber = random.nextInt(10);
                if (randomNumber % 3 == 0) {
                    //광고 송출
                    if (interstitialAd.isLoaded()) {
                        interstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }

                }

                if (arrayList.size() == 0) {
                    Toast.makeText(getActivity(), R.string.toast_check_list, Toast.LENGTH_SHORT).show();
                } else {

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

    private void loadInterstitialAd() {


        interstitialAd = new InterstitialAd(getContext());
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdClosed() {
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }

}
