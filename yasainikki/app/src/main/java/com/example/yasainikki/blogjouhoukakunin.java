package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class blogjouhoukakunin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogjouhoukakunin);
    }

    public void eleventh_button1(View view){ finish(); }

    public void eleventh_button2(View view){
        Intent intent = new Intent(this,blogtoukoukanryou.class);
        startActivities(new Intent[]{intent});
    }
}