package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yuzajouhoukanryou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuzajouhoukanryou);
    }

    public void eighteenth_button1(View view){
        Intent intent = new Intent(this,mypage.class);
        startActivities(new Intent[]{intent});
    }
}