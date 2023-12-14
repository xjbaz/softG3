package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    public void first_button1(View view){
        Intent intent = new Intent(this,riyokiyaku.class);
        startActivities(new Intent[]{intent});
    }

    public void first_button2(View view){
        Intent intent = new Intent(this,login.class);
        startActivities(new Intent[]{intent});
    }

}