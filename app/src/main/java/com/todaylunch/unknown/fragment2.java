package com.todaylunch.unknown;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


public class fragment2 extends Fragment {

    SQLiteOpenHelperMain dbHelper = null;
    SQLiteOpenHelperIcon dbHelperIcon = null;
    FloatingActionButton fab;
    MyAdapter_Fragment mAdapter;
    ArrayList<ListObject> mArrayList, searchArrayList;
    ArrayList<String> mArrayListIcon;
    EditText editTextSearch;
    Button btn_late, btn_long, btn_init;
    ProgressDialog progressDialog;
    CustomProgressDialog customProgressDialog;
    int fontNumber;
    TypefaceUtil typefaceUtil;
    TextView tvTitle;

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


        final RecyclerView mRecyclerView = view.findViewById(R.id.rv_frg2);
        LinearLayoutManager mLinearManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearManager);
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

                Intent intent = new Intent(getActivity(), AddMenu.class);
                intent.putExtra("TITLE", "Nothing");
                startActivity(intent);

            }
        });


        btn_late.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.sort(mArrayList);
                mAdapter.notifyDataSetChanged();

            }
        });

        btn_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.sort(mArrayList);
                Collections.reverse(mArrayList);
                //최신순으로 한 뒤 역순.
                mAdapter.notifyDataSetChanged();

            }
        });

        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.commit();
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
        searchArrayList = new ArrayList<>();

        fab = (FloatingActionButton) view.findViewById(R.id.fab_frg2);
        tvTitle = view.findViewById(R.id.tv_fragment2_main);
        editTextSearch = (EditText) view.findViewById(R.id.et_frg2);

        btn_late = (Button) view.findViewById(R.id.btn_frg2_late);
        btn_long = (Button) view.findViewById(R.id.btn_frg2_long);
        btn_init = (Button) view.findViewById(R.id.btn_init);

    }


}
