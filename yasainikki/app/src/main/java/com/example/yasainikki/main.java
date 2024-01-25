package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seventh_button1(View view){
        Intent intent = new Intent(this,bloghyouji.class);
        startActivities(new Intent[]{intent});
    }

    public void seventh_button2(View view){
        Intent intent = new Intent(this,blogkensaku.class);
        startActivities(new Intent[]{intent});
    }

    public void seventh_button3(View view){
        Intent intent = new Intent(this,blogsakusei.class);
        startActivities(new Intent[]{intent});
    }
}