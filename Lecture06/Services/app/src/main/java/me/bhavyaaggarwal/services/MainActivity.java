package me.bhavyaaggarwal.services;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnClick;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = findViewById(R.id.btnClick);
        tvResult = findViewById(R.id.tvResult);


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("");
                long x = System.currentTimeMillis();
                while (true) {
                    if (System.currentTimeMillis() - x >= 2000) {
                        break;
                    }
                }
                tvResult.setText("Hello");
            }
        });


    }
}
