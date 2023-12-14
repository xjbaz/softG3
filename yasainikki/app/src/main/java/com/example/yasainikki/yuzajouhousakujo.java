package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yuzajouhousakujo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuzajouhousakujo);
    }

    public void nineteenth_button1(View view){ finish(); }

    public void nineteenth_button2(View view){
        Intent intent = new Intent(this,yuzajouhousakujokakunin.class);
        startActivities(new Intent[]{intent});
    }
}