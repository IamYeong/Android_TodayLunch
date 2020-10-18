package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class ViewPagerIntro extends AppCompatActivity {

    private ArrayList<ViewPagerObject> arrayList;
    private ViewPager2 vp;
    private ViewPagerAdapter adapter;
    private DotsIndicator indicator;
    private ImageView previousButton, nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_view_pager_intro);

        previousButton = findViewById(R.id.img_viewpager_previous);
        nextButton = findViewById(R.id.img_viewpager_next);

        arrayList = new ArrayList<>();
        addValue();

        indicator = findViewById(R.id.dots_viewpager);
        vp = findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(this, arrayList);
        vp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vp.setAdapter(adapter);
        indicator.setViewPager2(vp);


        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }//onCreate

    private void addValue() {

        arrayList.add(new ViewPagerObject(R.color.color1, R.drawable.drawable_image_1, "가나다"));
        arrayList.add(new ViewPagerObject(R.color.color2, R.drawable.drawable_image_2, "라마바"));
        arrayList.add(new ViewPagerObject(R.color.color3, R.drawable.drawable_image_3, "사아자"));

    }


}
