package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yuzajouhoukakunin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuzajouhoukakunin);
    }

    public void fourth_button1(View view){
        finish();
    }

    public void fourth_button2(View view){
        Intent intent = new Intent(this,yuzatourokukanryou.class);
        startActivities(new Intent[]{intent});
    }
}