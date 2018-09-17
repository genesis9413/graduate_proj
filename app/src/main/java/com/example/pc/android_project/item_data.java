package com.example.pc.android_project;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class item_data extends LinearLayout
{
   Context mContext;
   LayoutInflater inflater;

   TextView textView1, textView2;

    public item_data(Context context){
      super(context);

      this.mContext = context;

      init();
    }

    public item_data(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        this.mContext = mContext;

        init();
    }

    private void init(){
        inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.item, this, true);

        textView1 = (TextView) findViewById(R.id.tv_word);
        textView2 = (TextView) findViewById(R.id.tv_mean);

    }

    public  void setWord(String word){
        textView1.setText(word);
    }

    public  void setMean(String mean){
        textView2.setText(mean);
    }

}

