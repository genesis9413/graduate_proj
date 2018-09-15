package com.example.pc.android_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class word_control extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<DriveVO> mydatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.listview);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mydatas = new ArrayList<>();
        mAdapter = new DriveAdapter(mydatas);
        mRecyclerView.setAdapter(mAdapter);

        DBHelper helper = new DBHelper(this);

        SQLiteDatabase db = helper.getWritableDatabase();


        /** DBHelper.java 에서 불러온 DB의 SQL문 작성 */
        Cursor cursor = db.rawQuery("SELECT * FROM wordTB", null);

        /** SQL문에서 출력된 값들을 하나씩 요소에 집어넣어 뿌릴 준비 */
        while (cursor.moveToNext()) {
            DriveVO vo = new DriveVO();
            vo.word = cursor.getString(0);
            vo.mean = cursor.getString(1);

            /** 출력 값들이 들어간 요소들을 ArrayList에 저장 */
            mydatas.add(vo);
        }

        db.close();
        helper.close();

    }

}





