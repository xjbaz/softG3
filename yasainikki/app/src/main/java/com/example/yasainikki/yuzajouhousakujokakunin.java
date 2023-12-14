package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yuzajouhousakujokakunin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuzajouhousakujokakunin);
    }

    public void twentieth_button1(View view){ finish(); }

    public void twentieth_button2(View view){
        Intent intent = new Intent(this,yuzajouhousakujokanryou.class);
        startActivities(new Intent[]{intent});
    }
}