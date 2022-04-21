package com.example.proiect;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {

        int n = 1000;

        // Sleep for the random amount of time
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result
        return "Ai terminat!";
    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
