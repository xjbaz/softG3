package com.example.yasainikki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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