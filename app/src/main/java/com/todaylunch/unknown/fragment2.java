package com.todaylunch.unknown;



import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;

import android.widget.FrameLayout;
import android.widget.TextView;



import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


public class fragment2 extends Fragment {

    private SQLiteOpenHelperMain dbHelper = null;
    private SQLiteOpenHelperIcon dbHelperIcon = null;
    private FloatingActionButton fab;
    private MyAdapter_Fragment mAdapter;
    private ArrayList<ListObject> mArrayList;
    private ArrayList<String> mArrayListIcon;
    private EditText editTextSearch;
    private Button btn_late, btn_long, btn_init;
    private CustomProgressDialog customProgressDialog;
    private int fontNumber;
    private TypefaceUtil typefaceUtil;
    private TextView tvTitle;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;

    private FrameLayout frameLayout;

    private boolean onResumeButton;

    public fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        customProgressDialog = new CustomProgressDialog(getContext());
        customProgressDialog.setProgressDialog();

        init(view);

        init_value();

        load_value();
        load_value_icon();

        typefaceUtil = new TypefaceUtil(getContext());
        fontNumber = MainActivity.FONT_NUMBER;

        editTextSearch.setTypeface(typefaceUtil.getTypeface(fontNumber));

        tvTitle.setTypeface(typefaceUtil.getTypeface(fontNumber));
        btn_late.setTypeface(typefaceUtil.getTypeface(fontNumber));
        btn_long.setTypeface(typefaceUtil.getTypeface(fontNumber));
        btn_init.setTypeface(typefaceUtil.getTypeface(fontNumber));
        fab.setBackgroundTintList(ColorStateList.valueOf(MainActivity.COLOR_NUMBER));
        frameLayout.setBackgroundColor(MainActivity.FRAMELAYOUT_NUMBER);


        mRecyclerView = view.findViewById(R.id.rv_frg2);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new MyAdapter_Fragment(mArrayList, mArrayListIcon, getActivity());
        mRecyclerView.setAdapter(mAdapter);


        customProgressDialog.offProgressDialog();


        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchKeyword = editTextSearch.getText().toString().toLowerCase(Locale.getDefault());
                mAdapter.filter(searchKeyword);

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("fragment2 : ", "fab click");

                Intent intent = new Intent(getActivity(), AddMenu.class);
                intent.putExtra("TITLE", "Nothing");
                startActivity(intent);

            }
        });


        btn_late.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("fragment2 : ", "lately click");

                Collections.sort(mArrayList);
                mAdapter.notifyDataSetChanged();

            }
        });

        btn_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("fragment2 : ", "old click");

                Collections.sort(mArrayList);
                Collections.reverse(mArrayList);
                //최신순으로 한 뒤 역순.
                mAdapter.notifyDataSetChanged();

            }
        });

        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("fragment2 : ", "init click");

                CustomProgressDialog dialog = new CustomProgressDialog(getContext());
                dialog.setProgressDialog();

                mArrayList.clear();
                mArrayListIcon.clear();

                load_value_icon();
                load_value();

                dialog.offProgressDialog();

                mAdapter.notifyDataSetChanged();


            }
        });



        return view;
    }

    private void init_value() {
        dbHelper = new SQLiteOpenHelperMain(getActivity());
        dbHelperIcon = new SQLiteOpenHelperIcon(getActivity());
    }

    private void load_value() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT, null);
        cursor.moveToFirst();


        for (int i = 0; i < cursor.getCount(); i++) {

                    long longCursor1 = cursor.getLong(0);
                    int intCursor2 = cursor.getInt(1);
                    int intCursor3 = cursor.getInt(2);
                    String strCursor4 = cursor.getString(3);
                    String strCursor5 = cursor.getString(4);

                    ListObject listObject = new ListObject(longCursor1, intCursor2, intCursor3, strCursor4, strCursor5);
                    mArrayList.add(listObject);
                    cursor.moveToNext();

                }
                cursor.close();
                db.close();
                Log.d("close", "fragment2 main db closed");


    }

    private void load_value_icon() {

        SQLiteDatabase db = dbHelperIcon.getReadableDatabase();
        Cursor cursor = db.rawQuery(MySQLite.SQL_SELECT2, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            String iconTitle = cursor.getString(1);
            mArrayListIcon.add(iconTitle);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        Log.d("close", "fragment2 menu db closed");

    }

    private void init(View view) {

        mArrayList = new ArrayList<>();
        mArrayListIcon = new ArrayList<>();

        fab = (FloatingActionButton) view.findViewById(R.id.fab_frg2);
        tvTitle = view.findViewById(R.id.tv_fragment2_main);
        editTextSearch = (EditText) view.findViewById(R.id.et_frg2);

        btn_late = (Button) view.findViewById(R.id.btn_frg2_late);
        btn_long = (Button) view.findViewById(R.id.btn_frg2_long);
        btn_init = (Button) view.findViewById(R.id.btn_init);

        frameLayout = view.findViewById(R.id.frame_fragment2);

    }

    @Override
    public void onResume() {
        super.onResume();

        if (onResumeButton == true) {

            CustomProgressDialog dialog = new CustomProgressDialog(getContext());
            dialog.setProgressDialog();

            mArrayList.clear();
            mArrayListIcon.clear();

            load_value_icon();
            load_value();

            dialog.offProgressDialog();

            mAdapter.notifyDataSetChanged();

        }

        onResumeButton = true;

    }
}
