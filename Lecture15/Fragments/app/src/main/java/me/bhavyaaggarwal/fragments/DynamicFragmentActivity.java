package me.bhavyaaggarwal.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DynamicFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        findViewById(R.id.btnBlue).setOnClickListener(this);
        findViewById(R.id.btnRed).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBlue:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flContainer, new BlueFragment())
                        .commit();
                break;
            case R.id.btnRed:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flContainer, new RedFragment())
                        .commit();
                break;
        }
    }
}
