package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class main extends AppCompatActivity {

    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //registerから登録した名前を受け取る
        userName = getIntent().getStringExtra("USER_NAME");


    }

    public void seventh_button1(View view){
        Intent intent = new Intent(this,bloghyouji.class);
        intent.putExtra("USER_NAME", userName);
        startActivities(new Intent[]{intent});
    }

    public void seventh_button2(View view){
        Intent intent = new Intent(this,blogkensaku.class);
        startActivities(new Intent[]{intent});
    }

    public void seventh_button3(View view){
        Intent nikkisakusei = new Intent(this,blogsakusei.class);
        nikkisakusei.putExtra("USER_NAME", userName);
        startActivities(new Intent[]{nikkisakusei});
    }
}