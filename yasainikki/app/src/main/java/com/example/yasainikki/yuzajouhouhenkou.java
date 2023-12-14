package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yuzajouhouhenkou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuzajouhouhenkou);
    }

    public void sixteenth_button1(View view){ finish(); }

    public void sixteenth_button2(View view){
        Intent intent = new Intent(this,yuzajouhouhenkoukakunin.class);
        startActivities(new Intent[]{intent});
    }

}