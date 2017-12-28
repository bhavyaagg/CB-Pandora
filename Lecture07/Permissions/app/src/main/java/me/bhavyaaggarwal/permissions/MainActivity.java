package me.bhavyaaggarwal.permissions;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "FILE";

    Button btnWriteFile, btnReadFile;
    TextView tvFileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFileData = findViewById(R.id.tvFileData);
        btnReadFile = findViewById(R.id.btnReadFile);
        btnWriteFile = findViewById(R.id.btnWriteFile);

        btnWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    writeFile();
                } catch (IOException e) {
                    Log.e(TAG, "Could not Write File", e);
                }
            }
        });

        btnReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tvFileData.setText(readFile());
                } catch (IOException e) {
                    Log.e(TAG, "Could not Read File", e);
                }
            }
        });
    }

    void writeFile() throws IOException {
        File sdCard = Environment.getExternalStorageDirectory();
        File helloTxt = new File(sdCard, "hello.txt");
        FileOutputStream foutStream = new FileOutputStream(helloTxt, true);
        foutStream.write("Hello There\n".getBytes());
    }

    String readFile() throws IOException {
        File sdCard = Environment.getExternalStorageDirectory();
        File helloTxt = new File(sdCard, "hello.txt");
        FileInputStream finStream = new FileInputStream(helloTxt);
        BufferedReader br = new BufferedReader(new InputStreamReader(finStream));
        StringBuilder sb = new StringBuilder("");
        String buf = br.readLine();
        while (buf != null) {
            sb.append(buf);
            sb.append("\n");
            buf = br.readLine();
        }
        return sb.toString();

    }
}
