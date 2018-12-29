package ui;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class DynamicActivity extends AppCompatActivity {


    private MyDatabaseHelper dbHelper;
    private EditText author;
    private EditText dynamic;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic);

        //db = this.openOrCreateDatabase("myMusic",MODE_PRIVATE,null);//判断数据库是否存在不存在就创建
        //dbHelper = this.openOrCreateDatabase("myMusic",MODE_PRIVATE,null);
        dbHelper = new MyDatabaseHelper(this, "MyDynamic.db", null, 1);

//        Button createDatabase = (Button) findViewById(R.id.create_database);
//        createDatabase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dbHelper.getWritableDatabase();
//            }
//        });


        author = (EditText) findViewById(R.id.editText2);
        dynamic = (EditText) findViewById(R.id.editText);



        Button addData = (Button) findViewById(R.id.send_button);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getWritableDatabase()会返回一个SQLiteDatabase对象
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                //获取作者和动态内容
                final String author1 = author.getText().toString();
                final String dynamic1 = dynamic.getText().toString();

                //获取系统时间
                SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日   HH:mm:ss");
                Date curDate =  new Date(System.currentTimeMillis());
                String   time_now   =   formatter.format(curDate);

                values.put("dynamic", dynamic1);
                values.put("author",author1);
                values.put("time",time_now);
                //insert（）方法中第一个参数是表名，第二个参数是表示给表中未指定数据的自动赋值为NULL。第三个参数是一个ContentValues对象
                db.insert("MyDynamic", null, values);
                values.clear();

                author.setText("");
                dynamic.setText("");

            }
        });


        Button back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DynamicActivity.this, Activity1.class);
                startActivity(intent);
            }
        });

//        Button queryButton = (Button) findViewById(R.id.query_data);
//        queryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                //指明去查询Book表。
//                Cursor cursor = db.query("MyDynamic", null, null, null, null, null, null);
//                //调用moveToFirst()将数据指针移动到第一行的位置。
//                if (cursor.moveToFirst()) {
//                    do {
//                        //然后通过Cursor的getColumnIndex()获取某一列中所对应的位置的索引
//                        String dynamic = cursor.getString(cursor.getColumnIndex("dynamic"));
//                        String author = cursor.getString(cursor.getColumnIndex("author"));
//                        String time = cursor.getString(cursor.getColumnIndex("time"));
//                        Log.d("DynamicActivity", "author is " + author);
//                        Log.d("DynamicActivity", "time is " + time);
//                        Log.d("DynamicActivity", "dynamic is " + dynamic);
//
//                    } while (cursor.moveToNext());
//                }
//                cursor.close();
//            }
//        });

    }

}
