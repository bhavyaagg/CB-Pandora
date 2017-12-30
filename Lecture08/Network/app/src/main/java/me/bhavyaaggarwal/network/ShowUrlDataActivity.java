package me.bhavyaaggarwal.network;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class ShowUrlDataActivity extends AppCompatActivity {

    EditText etUrl;
    Button btnShow;
    TextView tvContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_url_data);

        etUrl = findViewById(R.id.etUrl);
        btnShow = findViewById(R.id.btnShow);
        tvContents = findViewById(R.id.tvContents);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String urlString = etUrl.getText().toString();
                    URL url = new URL(urlString);
                    (new DownloadUrl()).execute(url);
                } catch (MalformedURLException e) {
                    Toast.makeText(ShowUrlDataActivity.this, "Wrong URL Format", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }

    public class DownloadUrl extends AsyncTask<URL, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvContents.setText(Html.fromHtml(s));
        }

        @Override
        protected String doInBackground(URL... urls) {

            try {
                HttpsURLConnection connection = (HttpsURLConnection) urls[0].openConnection();

                if (connection.getResponseCode() >= 200 && connection.getResponseCode() < 300) {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getInputStream())
                    );
                    StringBuilder sb = new StringBuilder();
                    String buf = br.readLine();
                    while (buf != null) {
                        sb.append(buf);
                        buf = br.readLine();
                    }
                    return sb.toString();
                }
            } catch (IOException e) {
                Toast.makeText(ShowUrlDataActivity.this, "Could not Connect", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

            return "";
        }
    }
}
