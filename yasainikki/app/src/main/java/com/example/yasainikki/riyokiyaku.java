package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Button;
import android.widget.CompoundButton;

public class riyokiyaku extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riyokiyaku);

        // SwitchとButtonを関連付け
        Switch second_switch1 = findViewById(R.id.second_switch1);
        Button second_button2 = findViewById(R.id.second_button2);

        second_button2.setVisibility(View.INVISIBLE);


        // Switchの状態変更を監視
        second_switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // SwitchがONの場合、ボタンを表示。OFFの場合、ボタンを非表示
                second_button2.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

    public void second_button1(View view){
        finish();
    }

    public void second_button2(View view){
        Intent intent = new Intent(this,yuzatouroku.class);
        startActivity(intent);
    }
}