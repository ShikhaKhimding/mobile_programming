package com.example.midterm_assingment_fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentDataInterface {

    Button btn;
    FirstFragment oneFragment;
    SecondFragment twoFragment;

    Button btn_click;

    EditText info;

    TextView textView;

    TextView t;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_frag);
        info = findViewById(R.id.data_en);
        t = findViewById(R.id.tv1);
        btn_click = findViewById(R.id.btn_alert);

        displayAlert();


        if(savedInstanceState == null){
            oneFragment = new FirstFragment();
            twoFragment = new SecondFragment();

            // Adding Fragments here are the ways
            FragmentManager fm =getSupportFragmentManager();
            FragmentTransaction fragmentTransaction =fm.beginTransaction();
            fragmentTransaction.add(R.id.first_holder,oneFragment);
            fragmentTransaction.add(R.id.second_holder,twoFragment);
            fragmentTransaction.commit();


        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typedValue = String.valueOf(info.getText());
                oneFragment.receivedData(typedValue);
                twoFragment.receivedData(typedValue);
            }
        });

    }
    public void displayAlert() {
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAlertDialog();
            }
        });

    }

    public void showAlertDialog(){

        AlertDialog.Builder customAlertDialog = new AlertDialog.Builder(MainActivity.this);
        customAlertDialog.setTitle("Another Activity");
        customAlertDialog.setIcon(R.mipmap.ic_launcher);
        customAlertDialog.setMessage("Wanna go to WelcomePage");
        customAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent myintent = new Intent(MainActivity.this, WelcomeActivity.class);

                startActivity(myintent);

            }
        });
        customAlertDialog.create();
        customAlertDialog.show();

    }
    public void sendDataToActivity(String value){
        t.setText(value);
    }
}