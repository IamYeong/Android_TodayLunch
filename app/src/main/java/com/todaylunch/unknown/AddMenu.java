package com.todaylunch.unknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddMenu extends AppCompatActivity {

    Button btn_cancel, btn_add, btn_delete;
    Spinner spr1, spr2;
    SQLiteOpenHelperIcon dbHelper = null;
    SQLiteOpenHelperMain dbHelperMain = null;
    ArrayList<ListObject3> arrayList;
    ArrayList<ListObject> arrayListMain;
    ArrayList arrayList2, arrayList3;
    int number;
    EditText editTextTitle, editTextLink;
    Intent intent;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private TextView tvTitle, tvLargeGroup, tvSub, tvName, tvUrl;
    private TypefaceUtil typefaceUtil;
    private int fontNumber, btnNumber;
    private ButtonDrawableUtil btnUtil;
    private CustomProgressDialog customProgressDialog;

    String getExtraTitle, getExtraLink;
    int getExtraMainMenu, getExtraDetailMenu;

    //Intent -> value intent -> value choice -> confirm -> insert value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        this.getWindow().setStatusBarColor(MainActivity.COLOR_NUMBER);

        customProgressDialog = new CustomProgressDialog(this);
        customProgressDialog.setProgressDialog();

        intent = getIntent();
        number = intent.getIntExtra("AddMenu", 0);

        init_value();

        getExtraTitle = intent.getStringExtra("TITLE");
        getExtraMainMenu = intent.getIntExtra("MENU1", 0);
        getExtraDetailMenu = intent.getIntExtra("MENU2", 0);
        getExtraLink = intent.getStringExtra("LINK");

        System.out.println("intent : " + number + ", " + getExtraTitle);

        arrayList = new ArrayList<>();
        arrayListMain = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();
        typefaceUtil = new TypefaceUtil(this);
        btnUtil = new ButtonDrawableUtil(this);
        fontNumber = MainActivity.FONT_NUMBER;
        btnNumber = MainActivity.BACKGROUND_NUMBER;

        load_value();
        load_menu_value();


        editTextTitle = (EditText) findViewById(R.id.et_add_title);
        editTextLink = (EditText) findViewById(R.id.et_add_link);

        tvTitle = (TextView) findViewById(R.id.tv_add_title);
        tvLargeGroup = (TextView) findViewById(R.id.tv_add_large_group);
        tvSub = (TextView) findViewById(R.id.tv_add_subdivision);
        tvName = (TextView) findViewById(R.id.tv_add_store_name);
        tvUrl = (TextView) findViewById(R.id.tv_add_url);

        tvTitle.setTypeface(typefaceUtil.getTypeface(fontNumber));
        tvLargeGroup.setTypeface(typefaceUtil.getTypeface(fontNumber));
        tvSub.setTypeface(typefaceUtil.getTypeface(fontNumber));
        tvName.setTypeface(typefaceUtil.getTypeface(fontNumber));
        tvUrl.setTypeface(typefaceUtil.getTypeface(fontNumber));

        btn_cancel = (Button) findViewById(R.id.btn_add_cancel);
        btn_add = (Button) findViewById(R.id.btn_add_add);
        btn_delete = (Button) findViewById(R.id.btn_menu_delete);

        editTextLink.setBackgroundColor(MainActivity.COLOR_NUMBER);
        editTextTitle.setBackgroundColor(MainActivity.COLOR_NUMBER);

        btn_delete.setBackground(btnUtil.getDrawable(btnNumber));
        btn_cancel.setBackground(btnUtil.getDrawable(btnNumber));
        btn_add.setBackground(btnUtil.getDrawable(btnNumber));

        spr1 = (Spinner) findViewById(R.id.spr_add1);
        spr2 = (Spinner) findViewById(R.id.spr_add2);

        spinnerMenuSetter();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrayList2);
        spr1.setAdapter(arrayAdapter);

        final ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrayList3);
        spr2.setAdapter(arrayAdapter2);

        editTextSetter();

        spinnerAutoSetter(arrayAdapter2);

        customProgressDialog.offProgressDialog();
        //spinnerAutoSetter();

        spr1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int spinnerPosition = spr1.getSelectedItemPosition();
                spinnerMenuSetter2(spinnerPosition + 1);
                arrayAdapter2.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int spinnerPosition2 = spr2.getSelectedItemPosition();

                Toast.makeText(AddMenu.this, "" + spinnerPosition2, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int menu1Number = (spr1.getSelectedItemPosition()) + 1;
                int menu2Number = (menu1Number * 9) + (spr2.getSelectedItemPosition() + 1);
                String menuTitle1 = editTextTitle.getText().toString();
                String strLink = editTextLink.getText().toString();

                System.out.println(menu1Number + ", " + menu2Number + ", " + menuTitle1 + ", " + strLink);

                System.out.println(overLabCheck(menuTitle1));

                insert_value(menu1Number, menu2Number, menuTitle1, strLink);

                finish();

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(AddMenu.this, "Cancel add menu", Toast.LENGTH_SHORT).show();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = dbHelperMain.getWritableDatabase();
                String deleteDb = MySQLite.SQL_DELETE + " WHERE " + MySQLite.ICOL_NAME4 + " ='" + getExtraTitle + "'";
                db.execSQL(deleteDb);
                db.close();
                Toast.makeText(AddMenu.this, "delete : " + getExtraTitle, Toast.LENGTH_SHORT).show();

            }
        });


    }//onCreate*************************

    //init_value
    private void init_value() {
        dbHelper = new SQLiteOpenHelperIcon(this);
        dbHelperMain = new SQLiteOpenHelperMain(this);
    }

    private void load_value() {

        SQLiteDatabase db = dbHelperMain.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            int intMenu1 = cursor.getInt(1);
            int intMenu2 = cursor.getInt(2);
            String strTitle = cursor.getString(3);
            String strLink = cursor.getString(4);

            ListObject listObject = new ListObject(intMenu1, intMenu2, strTitle, strLink);
            arrayListMain.add(listObject);

            cursor.moveToNext();
        }
        cursor.close();
        db.close();

    }

    private void load_menu_value() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT2, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            int number = cursor.getInt(0);
            String title = cursor.getString(1);
            int imgNumber = cursor.getInt(2);

            ListObject3 listObject = new ListObject3(number, title, imgNumber);
            arrayList.add(listObject);

            cursor.moveToNext();
        }
        cursor.close();
        db.close();
    }

    private void insert_value(int menuNumber1, int menuNumber2, String menuTitle, String strLink) {
        SQLiteDatabase db = dbHelperMain.getWritableDatabase();

        if (getExtraTitle.equals("Nothing") && overLabCheck(menuTitle)) {

            long longDate = date.getTime();

            String insertDb = MySQLite.SQL_INSERT + "(" + longDate + ", " + menuNumber1 + ", " + menuNumber2 + ", '" + menuTitle + "', '" + strLink + "')";
            //INSERT OR REPLACE TABLE_NAME (COLUMN1, COLUMN2, COLUMN3, COLUMN4, COLUMN5) VALUES ('DATE', NUM1, NUM2, 'TITLE', 'LINK')
            System.out.println(insertDb);
            db.execSQL(insertDb);
            db.close();

        } else {

            String updateDb = MySQLite.SQL_UPDATE + MySQLite.ICOL_NAME2 + " = " + menuNumber1 + ", '" + MySQLite.ICOL_NAME3 + "' = " + menuNumber2 + ", "
                     + MySQLite.ICOL_NAME4 + " = '" + menuTitle + "', " + MySQLite.ICOL_NAME5 + " = '" + strLink + "'" + " WHERE " + MySQLite.ICOL_NAME4 + " = '" + getExtraTitle + "'";
            db.execSQL(updateDb);
            db.close();

            System.out.println(updateDb);


        }

    }


    private boolean overLabCheck(String menuTitle) {
        for (int i = 0; i < arrayListMain.size(); i++) {
            if (arrayListMain.get(i).getStrTitle().equals(menuTitle)) {
                Toast.makeText(AddMenu.this, "같은 이름을 가진 곳이 이미 저장되어 있습니다.", Toast.LENGTH_SHORT).show();
                return false;

            } else {
                continue;
            }
        }
        return true;
    }

    private void spinnerMenuSetter() {

        //큰메뉴 9개 나열

        for (int i = 0; i < 9; i++) {

            String menuTitle = arrayList.get(i).getmTitle();
            arrayList2.add(menuTitle);

        }


    }

    private void spinnerMenuSetter2(int spinnerValue) {
        //큰메뉴 선택된거 없으면 상세메뉴 81개 전체 나열
        //큰메뉴 선택된거 있으면 해당하는 9개 나열

        arrayList3.removeAll(arrayList3);

        if(spinnerValue == -1) {
            Toast.makeText(this, "spinnerValue is -1", Toast.LENGTH_SHORT).show();
        } else {
            if (arrayList3.size() != 0) {
                arrayList3.remove(arrayList3);
            }
            for(int i = 0; i < 9; i++) {
                arrayList3.add(arrayList.get((spinnerValue * 9) + i).getmTitle());

            }
        }

    }

    private void spinnerAutoSetter(ArrayAdapter<String> arrayAdapter) {

        if (getExtraTitle.equals("Nothing") == false) {

            String mainMenu = arrayList.get(getExtraMainMenu - 1).getmTitle();
            String subMenu = arrayList.get(getExtraDetailMenu).getmTitle();

            int indexArray = (arrayList2.indexOf(mainMenu));

            spr1.setSelection(indexArray);
            spinnerMenuSetter2(indexArray + 1);
            arrayAdapter.notifyDataSetChanged();

            int indexArray2 = (arrayList3.indexOf(subMenu));
            spr2.setSelection(indexArray2 - 1);

        }

    }

    private void editTextSetter() {
        if (getExtraTitle.equals("Nothing")) {

        } else {

            editTextTitle.setText(getExtraTitle);
            editTextLink.setText(getExtraLink);

        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.updateResources(newBase));
    }
}
