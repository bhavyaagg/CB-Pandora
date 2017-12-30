package me.bhavyaaggarwal.network;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by bhavyaaggarwal on 30/12/17.
 */

public class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {
    public static final String TAG = "MyAsyncTask";

    TextView tvResult;

    public MyAsyncTask(TextView tvResult) {
        super();
        this.tvResult = tvResult;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: ");
    }


    @Override
    protected Void doInBackground(Integer... integers) {
        int countUpto = 0;
        if (integers.length > 0) countUpto = integers[0];

        for (int i = 0; i < countUpto; i++) {
            Log.d(TAG, "doInBackground: " + i);
            waitAsec();
            publishProgress(i + 1);
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        tvResult.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        tvResult.setText("DONE");
        super.onPostExecute(aVoid);
    }

    public void waitAsec() {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 1000;
        while (endTime > System.currentTimeMillis()) ;
    }

}
