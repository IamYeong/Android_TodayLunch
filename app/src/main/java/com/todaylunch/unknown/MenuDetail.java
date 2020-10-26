package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuDetail extends AppCompatActivity {

    TextView tvPath;
    FloatingActionButton fab;
    SQLiteOpenHelperIcon dbHelper = null;
    ArrayList<ListObject3> iconArrayList2;
    ArrayList arrayListTextView, arrayListImageView;
    Intent intent;
    int clickNumber;
    String clickTitle;
    private int typefaceNumber;

    private CustomProgressDialog customProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        this.getWindow().setStatusBarColor(MainActivity.COLOR_NUMBER);

        customProgressDialog = new CustomProgressDialog(this);
        customProgressDialog.setProgressDialog();

        TypefaceUtil typefaceUtil = new TypefaceUtil(this);
        typefaceNumber = MainActivity.FONT_NUMBER;

        intent = getIntent();
        clickNumber = intent.getIntExtra("Click", 0);
        clickTitle = intent.getStringExtra("title");
        Log.d("main menu number : ", "" + clickNumber);

        init_value();
        fab = (FloatingActionButton) findViewById(R.id.fab_detail);

        fab.setBackgroundTintList(ColorStateList.valueOf(MainActivity.COLOR_NUMBER));

        iconArrayList2 = new ArrayList<>();
        arrayListTextView = new ArrayList();
        arrayListImageView = new ArrayList();

        load_value(clickNumber);
        //tvPath.setText(getIntent().getStringExtra("TEXT_VIEW"));

        tvPath = (TextView) findViewById(R.id.tvPath);
        tvPath.setTypeface(typefaceUtil.getTypeface(typefaceNumber));
        tvPath.setText(clickTitle);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_menu_detail);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        DetailAdapter mAdapter = new DetailAdapter(this, iconArrayList2, clickNumber, clickTitle);
        recyclerView.setAdapter(mAdapter);

        customProgressDialog.offProgressDialog();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}
