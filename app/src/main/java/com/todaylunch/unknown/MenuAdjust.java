package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class MenuAdjust extends AppCompatActivity implements AdapterClickListener {

    private SQLiteOpenHelperIcon dbHelper = null;
    static int CLICK_NUMBER;

    private ArrayList<ListObject3> arrayList = new ArrayList<>();
    private AdjustAdapter mAdapter;
    private Button btnConfirm, btnCancel;
    private TextView adjustTitle;
    private TypefaceUtil typefaceUtil;
    private int fontNumber, btnNumber;
    private ButtonDrawableUtil btnUtil;
    public Intent intent;
    private int clickNumber;
    private ConstraintLayout constraintLayout;

    private DialogClickListener listener;

    /*
    public MenuAdjust() {
    }



    public void listenerConstruct(DialogClickListener mListener) {
        listener = mListener;
        Log.d("MenuAdjust :", "listenerConstruct run");
        System.out.println(listener);
    }

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adjust);

        this.getWindow().setStatusBarColor(MainActivity.COLOR_NUMBER);

        CustomProgressDialog progressDialog = new CustomProgressDialog(this);
        progressDialog.setProgressDialog();

        init();

        fontNumber = MainActivity.FONT_NUMBER;
        btnNumber = MainActivity.BACKGROUND_NUMBER;
        adjustTitle.setTypeface(typefaceUtil.getTypeface(fontNumber));
        btnCancel.setBackground(btnUtil.getDrawable(btnNumber));
        btnConfirm.setBackground(btnUtil.getDrawable(btnNumber));

        constraintLayout.setBackgroundColor(MainActivity.FRAMELAYOUT_NUMBER);

        intent = getIntent();
        clickNumber = intent.getIntExtra("MenuAdjust", -1);

        Log.d("CLickNumber : ", " " + clickNumber);

        init_value();
        load_value(clickNumber);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_adjust);
        mAdapter = new AdjustAdapter(this, arrayList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(mAdapter);

        progressDialog.offProgressDialog();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save_value(clickNumber);
                Log.d("MenuAdjust : ", "insert from/" + clickNumber);
                finish();

            }

        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MenuAdjust : ", "cancel");
                finish();
            }
        });



    }//onCreate()

    private void init_value() {
        dbHelper = new SQLiteOpenHelperIcon(this);
    }

    private void load_value(int extra) {
        //db -> arrayList
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT2, null);

        cursor.moveToPosition((extra * 9));

        for (int i = 0; i < 9; i++) {

            int number = cursor.getInt(0);
            String name = cursor.getString(1);
            int imgNumber = cursor.getInt(2);

            ListObject3 list = new ListObject3(number, name, imgNumber);

            arrayList.add(list);

            cursor.moveToNext();

        }
        cursor.close();

    }

    private void save_value(int intExtra) {
        //arrayList -> db
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if (intExtra == 0) {


            for (int i = 0; i < arrayList.size(); i++) {

                String saveTitle = arrayList.get(i).getmTitle();
                int saveImageNumber = arrayList.get(i).getmImgNum();

                String updateDb = MySQLite.SQL_UPDATE2 + MySQLite.CCOL_NAME2 + " = '" + saveTitle + "', " + MySQLite.CCOL_NAME3 + " = " + saveImageNumber
                        + " WHERE " + MySQLite.CCOL_NAME1 + " = " + (i + 1);

                db.execSQL(updateDb);
                //update
                //'column name = change value, clumn nmae2 = change value, ... where table name = present value'
            }

        } else {

            for (int i = 0; i < arrayList.size(); i++) {

                String saveTitle = arrayList.get(i).getmTitle();
                int saveImageNumber = arrayList.get(i).getmImgNum();
                String updateDb = MySQLite.SQL_UPDATE2 + MySQLite.CCOL_NAME2 + " = '" + saveTitle + "', " + MySQLite.CCOL_NAME3 + " = " + saveImageNumber
                        + " WHERE " + MySQLite.CCOL_NAME1 + " = " + ((intExtra * 9) + (i + 1));
                db.execSQL(updateDb);
                //update

            }

        }
        db.close();
        //Adapter notifychange 쓸지는 향후 결정
    }

    private void init() {
        typefaceUtil = new TypefaceUtil(this);
        btnUtil = new ButtonDrawableUtil(this);
        adjustTitle = findViewById(R.id.tv_menu_adjust_title);

        btnConfirm = (Button) findViewById(R.id.btn_adjust_confirm);
        btnCancel = (Button) findViewById(R.id.btn_adjust_cancel);

        constraintLayout = findViewById(R.id.frame_menu_adjust);
    }

    @Override
    public void onGridItemClickListener(int clickImageId) {
        Log.d("Choose menu image : ", "" + clickImageId);
        arrayList.get(CLICK_NUMBER).setmImgNum(clickImageId);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.updateResources(newBase));
    }
}