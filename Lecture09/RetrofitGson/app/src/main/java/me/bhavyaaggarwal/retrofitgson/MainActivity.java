package me.bhavyaaggarwal.retrofitgson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import me.bhavyaaggarwal.retrofitgson.models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit r = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        JsonPlaceholder api = r.create(JsonPlaceholder.class);

        api.getPostById(1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post p = response.body();
                Log.d(TAG, "onResponse: " + p.getUserId());
                Log.d(TAG, "onResponse: " + p.getId());
                Log.d(TAG, "onResponse: " + p.getTitle());
                Log.d(TAG, "onResponse: " + p.getBody());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}
