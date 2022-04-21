package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ExercitiuActivity extends AppCompatActivity {

    private static final String TEXT_STATE = "currentText";

    private TextView mTextView = null;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercitiu);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        //  Initialize mTextView
        mTextView = (TextView) findViewById(R.id.textView6);

        // Restore TextView if there is a savedInstanceState
        if(savedInstanceState!=null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }




    }

    public void startTask (View view) {
        // Put a message in the text view
        mTextView.setText(R.string.napping);

        // The AsyncTask has a callback that will update the text view.
        // Start the AsyncTask.
        new SimpleAsyncTask(mTextView).execute();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(ExercitiuActivity.this,"My notification").
                setSmallIcon(R.drawable.colors)
                .setContentTitle("Exercice")
                .setContentText("Exercice done!")
                .setAutoCancel(true);
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(ExercitiuActivity.this);
        managerCompat.notify(1,builder.build());
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}