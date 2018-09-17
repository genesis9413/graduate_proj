package com.example.pc.android_project;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class dialog_data extends LinearLayout
{
   Context mContext;
   LayoutInflater inflater;

   TextView textView1, textView2;

    public dialog_data(Context context){
      super(context);

      this.mContext = context;

      init();
    }

    public dialog_data(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        this.mContext = mContext;

        init();
    }

    private void init(){
        inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.item, this, true);

        textView1 = (TextView) findViewById(R.id.tv_speaker);
        textView2 = (TextView) findViewById(R.id.tv_dialog);

    }

    public void setSpeaker(String speaker){
        textView1.setText(speaker);
    }

    public  void setDialog(String dialog){
        textView2.setText(dialog);
    }

}

