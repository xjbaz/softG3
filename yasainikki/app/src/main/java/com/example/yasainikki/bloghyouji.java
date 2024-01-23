package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class bloghyouji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloghyouji);

        RequestQueue queue = Volley.newRequestQueue(this);
    }

    public void thirteenth_button1(View view){ finish(); }
}