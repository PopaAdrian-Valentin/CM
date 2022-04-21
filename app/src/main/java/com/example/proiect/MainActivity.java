package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button buttoncreare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1=findViewById(R.id.btn_ex);
        button1.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this,ExercitiuActivity.class);
            startActivity(intent);
        });

        buttoncreare=findViewById(R.id.btn_creare);
        buttoncreare.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Creare.class);
            startActivity(intent);
        });


    }

    public void Antrenament1(View view)
    {
        Intent intent =new Intent(MainActivity.this,Antrenament1.class);
        startActivity(intent);
    }


}