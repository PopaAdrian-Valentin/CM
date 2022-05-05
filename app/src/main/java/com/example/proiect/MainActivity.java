package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button_ant1;
    Button button_ant2;

    TextView txt_foot;

    double MagnitudePrevious = 0;
    Integer stepCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button_ant1=findViewById(R.id.btn_viewant1);
        button_ant1.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this,Antrenament1.class);
            startActivity(intent);
        });

        button_ant2=findViewById(R.id.btn_viewant2);
        button_ant2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Antrenament1.class);
            startActivity(intent);
        });

        txt_foot=findViewById(R.id.txt_foot);
        SensorManager sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener stepDetector=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {
                    float x_acceleration = sensorEvent.values[0];
                    float y_acceleration = sensorEvent.values[1];
                    float z_acceleration = sensorEvent.values[2];

                    double Magnitude = Math.sqrt(x_acceleration * x_acceleration + y_acceleration * y_acceleration + z_acceleration * z_acceleration);
                    double MagnitudeDelta = Magnitude - MagnitudePrevious;
                    MagnitudePrevious = Magnitude;

                    if (MagnitudeDelta > 6) {
                        stepCount++;
                    }
                    txt_foot.setText(stepCount.toString());
                }

            }


            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sensorManager.registerListener(stepDetector,sensor,SensorManager.SENSOR_DELAY_NORMAL);


    }

    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putInt("stepCount", stepCount);
        editor.apply();
    }

    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        stepCount = sharedPreferences.getInt("stepCount", 0);
    }

    public void Antrenament1(View view)
    {
        Intent intent =new Intent(MainActivity.this,Antrenament1.class);
        startActivity(intent);
    }


}