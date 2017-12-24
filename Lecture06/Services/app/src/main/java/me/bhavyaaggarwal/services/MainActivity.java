package me.bhavyaaggarwal.services;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnClick, btnStartService, btnStopService, btnChangeBK;
    TextView tvResult;
    FrameLayout flMain;

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flMain = findViewById(R.id.flMain);
        btnClick = findViewById(R.id.btnClick);
        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);
        btnChangeBK = findViewById(R.id.btnChangeBK);
        tvResult = findViewById(R.id.tvResult);

        final Handler h = new Handler();
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText("Hello");
                    }
                };
                tvResult.setText("");
                h.postDelayed(r, 2000);
            }
        });

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MyIntentService.class);
                startService(i);
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MyIntentService.class);
                stopService(i);
            }
        });

        btnChangeBK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flMain.setBackgroundColor(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            }
        });
    }
}
