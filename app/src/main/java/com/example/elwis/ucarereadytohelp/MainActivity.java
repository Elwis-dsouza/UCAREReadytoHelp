package com.example.elwis.ucarereadytohelp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button button;
    Button button1;
    Button button2;
    Button button4;
    Button button5;
    Button button6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UTIPEDIA.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,uti.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PatientDisplay.class);
                startActivity(intent);
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });


    }


}




