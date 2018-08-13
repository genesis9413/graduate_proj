package com.example.pc.android_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class script_control extends AppCompatActivity {

    TextView question, answer, ex;
    Button btnNext, btnPrev;
    DBHelper helper = new DBHelper(this);
    Cursor cursor;
    SQLiteDatabase db;

    String qu = "";
    String an = "";

    Integer p = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.script_view);

        question = (TextView) findViewById(R.id.question);
        answer = (TextView) findViewById(R.id.answer);
        ex = (TextView) findViewById(R.id.view);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrev = (Button) findViewById(R.id.btnPrev);

        Bundle bundle = getIntent().getExtras();
        Integer num = bundle.getInt("list_menu");

        // question.setText(ary);\

        db = helper.getWritableDatabase();



        if (num == 0) {
            cursor = db.rawQuery("SELECT question, answer FROM script_01TB WHERE _id == 1" , null);
            while (cursor.moveToNext()) {
                qu = cursor.getString(0);
                an = cursor.getString(1);
            }
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db = helper.getWritableDatabase();
                    ++p;
                    String a = p.toString();
                    Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();

                    cursor = db.rawQuery("SELECT question, answer FROM script_01TB WHERE _id == " + p, null);
                    while (cursor.moveToNext()) {
                        qu = cursor.getString(0);
                        an = cursor.getString(1);
                    }
                    question.setText(qu);
                    answer.setText(an);

                    cursor.close();
                    db.close();
                }
            });


        } else if (num == 1) {
            cursor = db.rawQuery("SELECT question, answer FROM script_02TB WHERE _id == " + p, null);
        }

        question.setText(qu);
        answer.setText(an);


        cursor.close();
        db.close();

    }
}