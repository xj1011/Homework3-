package ui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sqlite.sqler;


public class ThreeFragment extends Fragment {
    private ImageButton btn;

    private Button addData;
    private Button select;

    String titles;
    private EditText all_dynamic;
    private MyDatabaseHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_three, container, false);

        all_dynamic = (EditText) view.findViewById(R.id.editText3);

        //获取传过来的参数
        titles= (String) ((Activity1)getActivity()).getmTitles();
        Log.d("Activity1", "AllDynamic is " + titles);
        all_dynamic.setText(titles);

        btn = (ImageButton) view.findViewById(R.id.imageButton2);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(),DynamicActivity.class);
                startActivity(intent);
            }

        });

        return view;
    }


}
