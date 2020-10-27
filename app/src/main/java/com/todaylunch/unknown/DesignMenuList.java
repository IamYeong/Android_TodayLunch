package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DesignMenuList extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter_Design mAdapter;
    ArrayList<ListObject2> arrayList;
    TextView tvTitle;
    int fontNumber;
    TypefaceUtil typefaceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_menu_list);

        this.getWindow().setStatusBarColor(MainActivity.COLOR_NUMBER);

        fontNumber = MainActivity.FONT_NUMBER;
        typefaceUtil = new TypefaceUtil(this);
        tvTitle = findViewById(R.id.tv_menu_list);
        tvTitle.setTypeface(typefaceUtil.getTypeface(fontNumber));

        arrayList = new ArrayList<>();
        addMenu();

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_design_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new MyAdapter_Design(this, arrayList);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void addMenu() {

        String list1 = getResources().getString(R.string.colorpicker);
        String list2 = getResources().getString(R.string.font_dialog);
        String list3 = "Button";

        arrayList.add(new ListObject2(R.drawable.ic_filter_vintage_black_24dp, list1));
        arrayList.add(new ListObject2(R.drawable.ic_font_download_black_24dp, list2));
        arrayList.add(new ListObject2(R.drawable.ic_vignette_black_24dp, list3));

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.updateResources(newBase));
    }
}
