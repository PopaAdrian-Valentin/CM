package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Creare extends AppCompatActivity {

    Button btn_add;
    TextView text_nume;
    Spinner spinner_ex1;
    Spinner spinner_ex2;
    Spinner spinner_ex3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare);

        initView();
        loadData();
    }
    public void loadData(){
        DataBaseHelper dataBaseHelper=new DataBaseHelper(getApplicationContext());
        List<Exercitiu> ex=dataBaseHelper.findAllExercitii();
        if(!ex.isEmpty()){
            spinner_ex1.setAdapter(new ExercitiuAdapter(getApplicationContext(),R.layout.exercitiu_layout,ex));
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }

    }

    public void initView(){
        text_nume=findViewById(R.id.text_numeant);
        btn_add=findViewById(R.id.button5);
        spinner_ex1=findViewById(R.id.spinner_ex1);
        spinner_ex2=findViewById(R.id.spinner_ex2);
        spinner_ex3=findViewById(R.id.spinner_ex3);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_add_onClick(view);
            }
        });
    }

    public void btn_add_onClick(View view){
        DataBaseHelper dataBaseHelper=new DataBaseHelper(getApplicationContext());
        Antrenament antrenament=new Antrenament();
        antrenament.setNume(text_nume.getText().toString());
        Exercitiu exercitiu1 =(Exercitiu) spinner_ex1.getSelectedItem();
        Exercitiu exercitiu2 =(Exercitiu) spinner_ex2.getSelectedItem();
        Exercitiu exercitiu3 =(Exercitiu) spinner_ex3.getSelectedItem();
        antrenament.setExid1(exercitiu1.getId());
        antrenament.setExid2(exercitiu2.getId());
        antrenament.setExid3(exercitiu3.getId());
        if(dataBaseHelper.createAntrenament(antrenament)){
            Intent intent = new Intent(Creare.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }

}