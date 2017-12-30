package me.bhavyaaggarwal.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                MyAsyncTask task = new MyAsyncTask(new MyAsyncTask.MyAsyncTaskListener() {
                    @Override
                    public void onProgressUpdate(Integer... values) {
                        tvResult.setText(String.valueOf(values[0]));
                    }

                    @Override
                    public void onPostExecute() {
                        tvResult.setText("DONE");
                    }
                });
                task.execute(countUpto);
            }
        });

    }

}
