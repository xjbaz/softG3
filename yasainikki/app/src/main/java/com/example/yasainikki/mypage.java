package com.example.yasainikki;

import static androidx.navigation.ActivityKt.findNavController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class mypage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView3);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottomNav, navController);

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

    /**
     * BottomNavigationViewのイベント設定
     */

}