package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddExercitiu extends AppCompatActivity {

    private EditText text_nume;
    private EditText text_durata;
    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercitiu);
        initView();
    }

    public void initView(){
        text_nume=findViewById(R.id.text_nume);
        text_durata=findViewById(R.id.text_durata);
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_add_onClick(view);
            }
        });
    }

    public void btn_add_onClick(View view){
        DataBaseHelper dataBaseHelper=new DataBaseHelper(getApplicationContext());
        Exercitiu exercitiu=new Exercitiu();
        exercitiu.setNume(text_nume.getText().toString());
        exercitiu.setDurata(Integer.parseInt(text_durata.getText().toString()));
        if(dataBaseHelper.createExercitiu(exercitiu)){
            Intent intent = new Intent(AddExercitiu.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }


}