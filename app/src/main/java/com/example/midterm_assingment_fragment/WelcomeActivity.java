package com.example.midterm_assingment_fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        Intent myintent = getIntent();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater my = getMenuInflater();
        my.inflate(R.menu.mymenu, menu);
        MenuItem redItem = menu.findItem(R.id.action_red);
        redItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });

        MenuItem greenItem = menu.findItem(R.id.action_green);
        greenItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });

        MenuItem yellowItem = menu.findItem(R.id.action_yellow);
        yellowItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_red) {
            changeLayoutColor(Color.RED);
            return true;
        } else if (id == R.id.action_green) {
            changeLayoutColor(Color.GREEN);
            return true;
        } else if (id == R.id.action_yellow) {
            changeLayoutColor(Color.YELLOW);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void changeLayoutColor(int color) {
        View view = findViewById(R.id.Welcome);
        view.setBackgroundColor(color);
    }

}