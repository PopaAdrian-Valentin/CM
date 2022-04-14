package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Antrenament1 extends AppCompatActivity {

    Button buttonstart;
    pl.droidsonroids.gif.GifImageButton buttonstart2;
    Button buttonstart3;
    pl.droidsonroids.gif.GifImageButton buttonstart4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrenament1);

        buttonstart=findViewById(R.id.startAntrenament1);
        buttonstart.setOnClickListener(view -> {
            Intent intent = new Intent(Antrenament1.this, ExercitiuActivity.class);
            startActivity(intent);
        });

        buttonstart2=findViewById(R.id.gif);
        buttonstart2.setOnClickListener(view -> {
            Intent intent = new Intent(Antrenament1.this, ExercitiuActivity.class);
            startActivity(intent);
        });
        buttonstart=findViewById(R.id.startAntrenament2);
        buttonstart.setOnClickListener(view -> {
            Intent intent = new Intent(Antrenament1.this, ExercitiuActivity.class);
            startActivity(intent);
        });

        buttonstart2=findViewById(R.id.gif2);
        buttonstart2.setOnClickListener(view -> {
            Intent intent = new Intent(Antrenament1.this, ExercitiuActivity.class);
            startActivity(intent);
        });
    }

    public void Exercitiu(View view)
    {
        Intent intent =new Intent(Antrenament1.this, ExercitiuActivity.class);
        startActivity(intent);
    }
}