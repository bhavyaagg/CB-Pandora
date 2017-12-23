package me.bhavyaaggarwal.listviewswithmemoryhandling.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import me.bhavyaaggarwal.listviewswithmemoryhandling.R;
import me.bhavyaaggarwal.listviewswithmemoryhandling.models.Course;

/**
 * Created by bhavyaaggarwal on 23/12/17.
 */

public class CourseAdapter extends BaseAdapter {

    private ArrayList<Course> courses;
    Context context;

    public CourseAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }


    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Course getItem(int position) {
        return courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course_details, parent, false);

        TextView tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
        TextView tvCourseName = itemView.findViewById(R.id.tvCourseName);
        TextView tvOnGoing = itemView.findViewById(R.id.tvOnGoing);
        TextView tvLectureCount = itemView.findViewById(R.id.tvLectureCount);

        Course thisCourse = getItem(position);

        tvCourseName.setText(thisCourse.getName());
        tvTeacherName.setText(thisCourse.getTeacherName());
        tvOnGoing.setText(String.valueOf(thisCourse.isOnGoing()));
        tvLectureCount.setText(String.valueOf(thisCourse.getName()));

        return itemView;
    }

}
