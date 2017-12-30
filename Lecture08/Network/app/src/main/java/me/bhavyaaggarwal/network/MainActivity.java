package me.bhavyaaggarwal.network;

import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "NETWORKING";

    EditText etCount;
    Button btnSend;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCount = findViewById(R.id.etCount);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int countUpto = Integer.valueOf(etCount.getText().toString());
                MyAsyncTask task = new MyAsyncTask();
                task.execute(countUpto);
            }
        });

    }

    class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {

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
}
