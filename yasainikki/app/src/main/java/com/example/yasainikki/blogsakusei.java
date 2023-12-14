package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class blogsakusei extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogsakusei);
    }

    public void tenth_button1(View view){ finish(); }

    public void tenth_button2(View view){
        Intent intent = new Intent(this,blogjouhoukakunin.class);
        startActivities(new Intent[]{intent});
    }
}