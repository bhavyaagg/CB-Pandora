package me.bhavyaaggarwal.network;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by bhavyaaggarwal on 30/12/17.
 */
class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {

    public interface MyAsyncTaskListener {
        void onProgressUpdate(Integer... values);

        void onPostExecute();
    }

    private MyAsyncTaskListener listener;


    public MyAsyncTask(MyAsyncTaskListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int countUpto = 0;
        if (integers.length > 0) countUpto = integers[0];

        for (int i = 0; i < countUpto; i++) {
            waitAsec();
            publishProgress(i + 1);
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if (listener != null)
            listener.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (listener != null)
            listener.onPostExecute();
    }

    public static void waitAsec() {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 1000;
        while (endTime > System.currentTimeMillis()) ;
    }

}
