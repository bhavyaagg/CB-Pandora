package me.bhavyaaggarwal.listviewswithmemoryhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import me.bhavyaaggarwal.listviewswithmemoryhandling.Adapters.CourseAdapter;
import me.bhavyaaggarwal.listviewswithmemoryhandling.models.Course;

public class MainActivity extends AppCompatActivity {
    ArrayList<Course> courseList = Course.genRandCourses(100);
    ListView lvCourseDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourseDetails = findViewById(R.id.lvCourseDetails);
        CourseAdapter courseAdapter = new CourseAdapter(this, courseList);
        lvCourseDetails.setAdapter(courseAdapter);
    }
}
