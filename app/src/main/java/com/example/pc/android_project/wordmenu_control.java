package com.example.pc.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class wordmenu_control extends AppCompatActivity {

    Button menu_btn1, menu_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_menu);

        menu_btn1 = (Button)findViewById(R.id.menu_btn1);
        menu_btn2 = (Button)findViewById(R.id.menu_btn2);

        menu_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wordmenu_control.this, word_control.class);

                startActivity(intent);
            }
        });

        menu_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wordmenu_control.this, word_control.class);

                startActivity(intent);
            }
        });


    }
}
