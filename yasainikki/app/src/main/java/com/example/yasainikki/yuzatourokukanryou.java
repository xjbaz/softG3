package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yuzatourokukanryou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuzatourokukanryou);
    }

    public void fifth_button2(View view){
        Intent intent = new Intent(this,main.class);
        startActivities(new Intent[]{intent});
    }
}