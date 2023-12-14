package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mypage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
    }
    public void eighth_button1(View view){
        Intent intent = new Intent(this,bloghyouji.class);
        startActivities(new Intent[]{intent});
    }
    public void eighth_button2(View view){
        Intent intent = new Intent(this,fororan.class);
        startActivities(new Intent[]{intent});
    }

    public void eighth_button3(View view){
        Intent intent = new Intent(this,forowaran.class);
        startActivities(new Intent[]{intent});
    }

    public void eighth_button4(View view){
        Intent intent = new Intent(this,yuzajouhouhenkou.class);
        startActivities(new Intent[]{intent});
    }

    public void eighth_button5(View view){
        Intent intent = new Intent(this,yuzajouhousakujo.class);
        startActivities(new Intent[]{intent});
    }
    public void eighth_button7(View view){
        Intent intent = new Intent(this,title.class);
        startActivities(new Intent[]{intent});
    }

    public void eighth_button8(View view){
        Intent intent = new Intent(this,main.class);
        startActivities(new Intent[]{intent});
    }
}