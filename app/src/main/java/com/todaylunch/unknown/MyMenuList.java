package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MyMenuList extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter_Fragment mAdapter;
    ArrayList<ListObject> arrayList;
    ArrayList<String> arrayListIcon;
    ArrayList<String> arrayListName;
    SQLiteOpenHelperIcon dbHelperIcon;
    SQLiteOpenHelperMain dbHelper;
    FloatingActionButton fab;
    Intent intentDetail;
    int clickNumber;
    String clickTitle1, clickTitle2;
    TextView pathText1, pathText2, right1, right2, tvMain;
    EditText searchEditText;
    Button btn_late, btn_long, btn_init;
    ProgressDialog progressDialog;
    private int fontNumber, btnNumber;
    private TypefaceUtil typefaceUtil;
    private ButtonDrawableUtil btnUtil;
    private CustomProgressDialog customProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragment2);

        this.getWindow().setStatusBarColor(MainActivity.COLOR_NUMBER);

        customProgressDialog = new CustomProgressDialog(this);
        customProgressDialog.setProgressDialog();

        intentDetail = getIntent();
        clickNumber = intentDetail.getIntExtra("ClickNumber", 0);
        clickTitle1 = intentDetail.getStringExtra("title");
        clickTitle2 = intentDetail.getStringExtra("title2");

        Log.d("Click menu number : ", "" + clickNumber);

        typefaceUtil = new TypefaceUtil(this);
        btnUtil = new ButtonDrawableUtil(this);
        fontNumber = MainActivity.FONT_NUMBER;
        btnNumber = MainActivity.BACKGROUND_NUMBER;

        tvMain = findViewById(R.id.tv_fragment2_main);
        tvMain.setTypeface(typefaceUtil.getTypeface(fontNumber));
        pathText1 = (TextView) findViewById(R.id.tv_path_list1);
        pathText1.setTypeface(typefaceUtil.getTypeface(fontNumber));
        pathText2 = (TextView) findViewById(R.id.tv_path_list2);
        pathText2.setTypeface(typefaceUtil.getTypeface(fontNumber));
        right1 = (TextView) findViewById(R.id.tv_right1);
        right2 = (TextView) findViewById(R.id.tv_right2);
        searchEditText = (EditText) findViewById(R.id.et_frg2);
        btn_late = (Button) findViewById(R.id.btn_frg2_late);
        btn_long = (Button) findViewById(R.id.btn_frg2_long);
        btn_init = (Button) findViewById(R.id.btn_init);

        btn_init.setBackground(btnUtil.getDrawable(btnNumber));
        btn_long.setBackground(btnUtil.getDrawable(btnNumber));
        btn_late.setBackground(btnUtil.getDrawable(btnNumber));

        right1.setText(" > ");
        pathText1.setText(clickTitle1);
        right2.setText(" > ");
        pathText2.setText(clickTitle2);

        init_value();
        //activity_my_menu_list
        arrayList = new ArrayList<>();
        arrayListIcon = new ArrayList<>();
        //arrayListName = new ArrayList<>();

        fab = (FloatingActionButton) findViewById(R.id.fab_frg2);

        fab.setBackgroundTintList(ColorStateList.valueOf(MainActivity.COLOR_NUMBER));

        load_value();
        load_value_icon();

        //전체 목록 중 몇 번 메뉴를 클릭했느냐에 따라 sort하는 함수 추가.

        recyclerView = (RecyclerView) findViewById(R.id.rv_frg2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new MyAdapter_Fragment(arrayList, arrayListIcon, this);
        recyclerView.setAdapter(mAdapter);

        customProgressDialog.offProgressDialog();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MyMenuList.this, AddMenu.class);
                intent.putExtra("TITLE", "Nothing");
                startActivity(intent);

            }
        });


        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchKeyword = searchEditText.getText().toString().toLowerCase(Locale.getDefault());
                System.out.println(searchKeyword);
                mAdapter.filter(searchKeyword);

            }
        });

        btn_late.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.sort(arrayList);

                mAdapter.notifyDataSetChanged();

            }
        });

        btn_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.sort(arrayList);
                Collections.reverse(arrayList);

                mAdapter.notifyDataSetChanged();

            }
        });

        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

    }//onCreate()

    private void init_value() {
        dbHelper = new SQLiteOpenHelperMain(this);
        dbHelperIcon = new SQLiteOpenHelperIcon(this);
    }

    private void load_value() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT + " WHERE " + MySQLite.ICOL_NAME3 + "=" + clickNumber, null);
        cursor.moveToFirst();

        if(cursor.getCount() == 0) {
            Toast.makeText(this, "표시할 목록이 없습니다.", Toast.LENGTH_SHORT).show();

        } else {

            for (int i = 0; i < cursor.getCount(); i++) {

                long longCursor1 = cursor.getLong(0);
                int intCursor2 = cursor.getInt(1);
                int intCursor3 = cursor.getInt(2);
                String strCursor4 = cursor.getString(3);
                String strCursor5 = cursor.getString(4);

                ListObject listObject = new ListObject(longCursor1, intCursor2, intCursor3, strCursor4, strCursor5);

                arrayList.add(listObject);
                cursor.moveToNext();

            }
            cursor.close();
            db.close();


        }

    }

    private void load_value_icon() {

        SQLiteDatabase db = dbHelperIcon.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT2, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            String iconTitle = cursor.getString(1);
            arrayListIcon.add(iconTitle);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();

    }


}
