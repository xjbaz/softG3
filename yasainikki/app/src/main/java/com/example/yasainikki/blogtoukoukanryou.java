package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class blogtoukoukanryou extends AppCompatActivity {
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogtoukoukanryou);

        userName = getIntent().getStringExtra("USER_NAME");
    }

    public void twelfth_button1(View view){
        Intent intent = new Intent(this,main.class);
        startActivities(new Intent[]{intent});
    }
}