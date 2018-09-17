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

    TextView question, answer;
    Button btnNext;
    DBHelper helper = new DBHelper(this);
    Cursor cursor;
    SQLiteDatabase db;

    String qu = "";
    String an = "";

    /**
     * DB 테이블 id 증가시켜주는 변수
     */
    Integer i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.script_view);

        question = (TextView) findViewById(R.id.question);
        answer = (TextView) findViewById(R.id.answer);

        btnNext = (Button) findViewById(R.id.btnNext);

        Bundle bundle = getIntent().getExtras();
        Integer num = bundle.getInt("list_menu");

        db = helper.getWritableDatabase();

        /** 리스트 <1. 인사>를 선택했을 경우 */
        if (num == 0) {
            cursor = db.rawQuery("SELECT question, answer FROM script_01TB WHERE _id == 1", null);
            while (cursor.moveToNext()) {
                qu = cursor.getString(0);
                an = cursor.getString(1);
            }
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db = helper.getWritableDatabase();
                    ++i;
                    if (i > 4)
                        i = 1;
                    cursor = db.rawQuery("SELECT question, answer FROM script_01TB WHERE _id == " + i, null);
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

            /** 리스트 <2. 대중교통>을 선택했을 경우 */
        } else if (num == 1) {
            cursor = db.rawQuery("SELECT question, answer FROM script_02TB WHERE _id == 1", null);
            while (cursor.moveToNext()) {
                qu = cursor.getString(0);
                an = cursor.getString(1);
            }
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db = helper.getWritableDatabase();
                    ++i;
                    if (i > 4)
                        i = 1;
                    cursor = db.rawQuery("SELECT question, answer FROM script_02TB WHERE _id == " + i, null);
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
            /** 리스트 <3. 마트(시장)>을 선택했을 경우 */
        } else {
            cursor = db.rawQuery("SELECT question, answer FROM script_03TB WHERE _id == 1", null);
            while (cursor.moveToNext()) {
                qu = cursor.getString(0);
                an = cursor.getString(1);
            }
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db = helper.getWritableDatabase();
                    ++i;
                    if (i > 2)
                        i = 1;
                    cursor = db.rawQuery("SELECT question, answer FROM script_03TB WHERE _id == " + i, null);
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
        }

        /** 첫 대화화면 출력 */
        question.setText(qu);
        answer.setText(an);

        cursor.close();
        db.close();

    }
}