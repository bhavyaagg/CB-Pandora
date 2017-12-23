package me.bhavyaaggarwal.listviewswithmemoryhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import me.bhavyaaggarwal.listviewswithmemoryhandling.Adapters.CourseRecyclerAdapter;
import me.bhavyaaggarwal.listviewswithmemoryhandling.models.Course;

public class RecyclerViewActivity extends AppCompatActivity {

    ArrayList<Course> courses = Course.genRandCourses(50);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView rvCourses = findViewById(R.id.rvCourses);
        CourseRecyclerAdapter courseRecyclerAdapter = new CourseRecyclerAdapter(this, courses);

        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        rvCourses.setAdapter(courseRecyclerAdapter);
    }
}
