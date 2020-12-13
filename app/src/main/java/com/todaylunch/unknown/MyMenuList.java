package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MyMenuList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter_Fragment mAdapter;
    private ArrayList<ListObject> arrayList;
    private ArrayList<String> arrayListIcon;
    private SQLiteOpenHelperIcon dbHelperIcon;
    private SQLiteOpenHelperMain dbHelper;
    private FloatingActionButton fab;
    private Intent intentDetail;
    protected int clickNumber, clickMainNumber;
    private String clickTitle1, clickTitle2;
    private TextView pathText1, pathText2, right1, right2, tvMain;
    private EditText searchEditText;
    private Button btn_late, btn_long, btn_init;
    private LinearLayoutManager linearLayoutManager;
    private FrameLayout frameLayout;

    private TypefaceUtil typefaceUtil;
    private Typeface typeface;

    private boolean onResumeButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragment2);

        this.getWindow().setStatusBarColor(MainActivity.COLOR_NUMBER);



        init();

        typeface = typefaceUtil.getTypeface(MainActivity.FONT_NUMBER);

        intentDetail = getIntent();
        clickMainNumber = intentDetail.getIntExtra("ClickMainNumber", 0);
        clickNumber = intentDetail.getIntExtra("ClickNumber", 0);
        clickTitle1 = intentDetail.getStringExtra("title");
        clickTitle2 = intentDetail.getStringExtra("title2");

        Log.d("Click menu number : ",  clickMainNumber + ", " + clickNumber);

        //init_value();
        //load_value();
        //load_value_icon();

        NewThread nt = new NewThread(MyMenuList.this);
        nt.execute();

        tvMain.setTypeface(typeface);
        pathText1.setTypeface(typeface);
        pathText2.setTypeface(typeface);
        fab.setBackgroundTintList(ColorStateList.valueOf(MainActivity.COLOR_NUMBER));
        frameLayout.setBackgroundColor(MainActivity.FRAMELAYOUT_NUMBER);

        right1.setText(" > ");
        pathText1.setText(clickTitle1);
        right2.setText(" > ");
        pathText2.setText(clickTitle2);


        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new MyAdapter_Fragment();
        recyclerView.setAdapter(mAdapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MyMenuList : ", "fab click");

                Intent intent = new Intent(MyMenuList.this, AddMenu.class);

                intent.putExtra("TITLE", "Nothing");
                intent.putExtra("MENU1", clickMainNumber);
                intent.putExtra("MENU2", clickNumber);

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
                mAdapter.filter(searchKeyword);

            }
        });

        btn_late.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MyMenuList : ", "lately click");

                Collections.sort(arrayList);

                mAdapter.notifyDataSetChanged();

            }
        });

        btn_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MyMenuList : ", "old click");

                Collections.sort(arrayList);
                Collections.reverse(arrayList);

                mAdapter.notifyDataSetChanged();

            }
        });

        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MyMenuList : ", "init click");

                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

    }//onCreate()

    private class NewThread extends AsyncTask<Integer, Integer, Boolean> {

        private Context context;
        private CustomProgressDialog dialog;

        private NewThread(Context context) {
            this.context = context;

        }

        @Override
        protected void onPreExecute() {

            init_value();
            dialog = new CustomProgressDialog(context);
            dialog.settingCustomProgressDialog();

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            //mAdapter.notifyDataSetChanged();

            linearLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(linearLayoutManager);
            mAdapter = new MyAdapter_Fragment(arrayList, arrayListIcon, context);
            recyclerView.setAdapter(mAdapter);

            dialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected Boolean doInBackground(Integer... integers) {

            load_value();
            load_value_icon();

            return null;
        }
    }

    private void init_value() {
        dbHelper = new SQLiteOpenHelperMain(this);
        dbHelperIcon = new SQLiteOpenHelperIcon(this);
    }

    private void load_value() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT + " WHERE " + MySQLite.ICOL_NAME3 + "=" + clickNumber, null);


        if(cursor.getCount() == 0) {
            cursor.close();
            db.close();

        } else {

            cursor.moveToFirst();

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

    private void init() {

        typefaceUtil = new TypefaceUtil(this);

        arrayList = new ArrayList<>();
        arrayListIcon = new ArrayList<>();

        tvMain = findViewById(R.id.tv_fragment2_main);
        pathText1 = (TextView) findViewById(R.id.tv_path_list1);
        pathText2 = (TextView) findViewById(R.id.tv_path_list2);
        right1 = (TextView) findViewById(R.id.tv_right1);
        right2 = (TextView) findViewById(R.id.tv_right2);
        searchEditText = (EditText) findViewById(R.id.et_frg2);
        btn_late = (Button) findViewById(R.id.btn_frg2_late);
        btn_long = (Button) findViewById(R.id.btn_frg2_long);
        btn_init = (Button) findViewById(R.id.btn_init);
        fab = (FloatingActionButton) findViewById(R.id.fab_frg2);
        frameLayout = findViewById(R.id.frame_fragment2);

        recyclerView = (RecyclerView) findViewById(R.id.rv_frg2);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.updateResources(newBase));
    }

    @Override
    protected void onResume() {
        super.onResume();



        if (onResumeButton == true) {

            arrayListIcon.clear();
            arrayList.clear();

            load_value_icon();
            load_value();

            mAdapter.notifyDataSetChanged();

        }

        onResumeButton = true;





    }
}
