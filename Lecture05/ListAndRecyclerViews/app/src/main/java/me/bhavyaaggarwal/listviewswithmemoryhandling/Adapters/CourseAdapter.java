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
    public int getItemViewType(int position) {
        return getItem(position).getLectures() > 15 ? 0 : 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (getItemViewType(position) == 0) {
                convertView = li.inflate(R.layout.list_item_course_right, parent, false);
            } else {
                convertView = li.inflate(R.layout.list_item_course_left, parent, false);
            }
        }
        TextView tvTeacherName = convertView.findViewById(R.id.tvTeacherName);
        TextView tvCourseName = convertView.findViewById(R.id.tvCourseName);
        TextView tvOnGoing = convertView.findViewById(R.id.tvOnGoing);
        TextView tvLectureCount = convertView.findViewById(R.id.tvLectureCount);

        Course thisCourse = getItem(position);

        tvCourseName.setText(thisCourse.getName());
        tvTeacherName.setText(thisCourse.getTeacherName());
        tvOnGoing.setText(String.valueOf(thisCourse.isOnGoing()));
        tvLectureCount.setText(String.valueOf(thisCourse.getLectures()));

        return convertView;
    }

}
