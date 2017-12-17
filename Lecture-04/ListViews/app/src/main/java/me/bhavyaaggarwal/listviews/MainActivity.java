package me.bhavyaaggarwal.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] courses = {
            "Pandora",
            "Elixir",
            "Launchpad",
            "Crux",
            "Perceptron",
            "Gamedev",
            "Competitive Coding",
            "Algo++",
            "Pandora",
            "Elixir",
            "Launchpad",
            "Crux",
            "Perceptron",
            "Gamedev",
            "Competitive Coding",
            "Algo++"
    };

    ListView lvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvCourses);

        ArrayAdapter<String> courseAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                courses
        );

        lvCourses.setAdapter(courseAdapter);
    }
}
