package me.bhavyaaggarwal.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etNumber;
    Button btnSendEmail, btnSendNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etNumber = findViewById(R.id.etNumber);

        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnSendNumber = findViewById(R.id.btnSendNumber);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + etEmail.getText().toString()));
                startActivity(emailIntent);
            }
        });
    }
}
