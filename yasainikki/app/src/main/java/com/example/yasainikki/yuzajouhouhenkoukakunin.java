package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yuzajouhouhenkoukakunin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuzajouhouhenkoukakunin);
    }

    public void seventeenth_button1(View view){ finish(); }

    public void seventeenth_button2(View view){
        Intent intent = new Intent(this,yuzajouhoukanryou.class);
        startActivities(new Intent[]{intent});
    }
}