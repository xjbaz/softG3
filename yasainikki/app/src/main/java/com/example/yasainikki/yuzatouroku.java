package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yuzatouroku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuzatouroku);
    }

    public void third_button1(View view){
        finish();
    }

    public void third_button2(View view){
        Intent intent = new Intent(this,yuzajouhoukakunin.class);
        startActivities(new Intent[]{intent});
    }
}