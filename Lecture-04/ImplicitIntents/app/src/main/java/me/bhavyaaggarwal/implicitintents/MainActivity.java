package me.bhavyaaggarwal.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etPhone, etEmail;
    Button btnDial, btnSendMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);

        btnDial = findViewById(R.id.btnDial);
        btnSendMail = findViewById(R.id.btnSendMail);

        btnDial.setOnClickListener(this);
        btnSendMail.setOnClickListener(this);

    }

    // URI - Universal resource identifier
    // Scheme and host are compulsory
    // Some schemes require "//" some don't
    // scheme  host  path  hash  query
    // http://mail.google.com/u/0/#inbox?mailid=24
    // scheme: http://
    // host: mail.google.com
    // path: /u/0
    // hash: #inbox
    // query: ?mailid=24

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDial:
                Intent i1 = new Intent(Intent.ACTION_DIAL);
                i1.setData(Uri.parse("tel:" + etPhone.getText().toString()));
                startActivity(i1);
                break;
            case R.id.btnSendMail:
                Intent i2 = new Intent(Intent.ACTION_SENDTO);
                i2.setData(Uri.parse("mailto:" + etEmail.getText().toString()));
                startActivity(i2);
                break;
        }
    }
}
