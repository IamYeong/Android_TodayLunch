package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MenuDetail extends AppCompatActivity {

    private TextView tvPath;
    private FloatingActionButton fab;
    private SQLiteOpenHelperIcon dbHelper = null;
    private ArrayList<ListObject3> iconArrayList2;
    public ArrayList arrayListTextView, arrayListImageView;
    private Intent intent;
    private int clickNumber;
    private String clickTitle;
    private int typefaceNumber;
    private boolean onResumeButton = false;

    private RecyclerView recyclerView;
    private DetailAdapter mAdapter;
    private GridLayoutManager gridLayoutManager;

    private TypefaceUtil typefaceUtil;

    private FrameLayout frameLayout;

    private CustomProgressDialog customProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        this.getWindow().setStatusBarColor(MainActivity.COLOR_NUMBER);

        customProgressDialog = new CustomProgressDialog(this);
        customProgressDialog.setProgressDialog();

        init();

        frameLayout.setBackgroundColor(MainActivity.FRAMELAYOUT_NUMBER);
        typefaceNumber = MainActivity.FONT_NUMBER;

        intent = getIntent();
        clickNumber = intent.getIntExtra("Click", 0);
        clickTitle = intent.getStringExtra("title");
        Log.d("main menu number : ", "" + clickNumber);

        init_value();

        fab.setBackgroundTintList(ColorStateList.valueOf(MainActivity.COLOR_NUMBER));


        load_value(clickNumber);
        //tvPath.setText(getIntent().getStringExtra("TEXT_VIEW"));

        tvPath.setTypeface(typefaceUtil.getTypeface(typefaceNumber));
        tvPath.setText(clickTitle);

        recyclerView = (RecyclerView) findViewById(R.id.rv_menu_detail);
        gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new DetailAdapter(this, iconArrayList2, clickNumber, clickTitle);
        recyclerView.setAdapter(mAdapter);

        customProgressDialog.offProgressDialog();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MenuDetail : ", "fab click");

                Intent intent2 = new Intent(getApplicationContext(), MenuAdjust.class);
                intent2.putExtra("MenuAdjust", clickNumber);
                startActivity(intent2);

            }
        });

    }

    private void load_value(int intExtra) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT2, null);
        cursor.moveToPosition(intExtra * 9);
        for (int i=0; i < 9; i++) {

            int menuNumber = cursor.getInt(0);
            String menuTitle = cursor.getString(1);
            int menuImageNumber = cursor.getInt(2);

            ListObject3 menuObject = new ListObject3(menuNumber, menuTitle, menuImageNumber);

            iconArrayList2.add(menuObject);

            cursor.moveToNext();

        }
        cursor.close();
        db.close();
        Log.d("close", "Detail Menu db closed");
    }

    private void init_value() {
        dbHelper = new SQLiteOpenHelperIcon(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.updateResources(newBase));
    }

    @Override
    protected void onResume() {
        super.onResume();

        CustomProgressDialog dialog = new CustomProgressDialog(this);
        dialog.setProgressDialog();

        if (onResumeButton == true) {

            iconArrayList2.clear();

            load_value(clickNumber);

            mAdapter.notifyDataSetChanged();

        }

        onResumeButton = true;
        dialog.offProgressDialog();
    }

    private void init() {

        frameLayout = findViewById(R.id.frame_detail);
        fab = (FloatingActionButton) findViewById(R.id.fab_detail);
        tvPath = (TextView) findViewById(R.id.tvPath);

        typefaceUtil = new TypefaceUtil(this);

        iconArrayList2 = new ArrayList<>();
        arrayListTextView = new ArrayList();
        arrayListImageView = new ArrayList();

    }



}
