package me.bhavyaaggarwal.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int res = getIntent().getIntExtra("Result", 0);

        tvResult = findViewById(R.id.tvResult);
        tvResult.setText(String.valueOf(res));
    }
}
