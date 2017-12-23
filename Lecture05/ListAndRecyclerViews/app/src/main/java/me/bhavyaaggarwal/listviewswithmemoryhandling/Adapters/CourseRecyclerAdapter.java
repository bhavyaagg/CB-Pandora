package me.bhavyaaggarwal.listviewswithmemoryhandling.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import me.bhavyaaggarwal.listviewswithmemoryhandling.R;
import me.bhavyaaggarwal.listviewswithmemoryhandling.models.Course;

/**
 * Created by bhavyaaggarwal on 23/12/17.
 */

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder> {
    private Context context;
    private ArrayList<Course> courses;

    public CourseRecyclerAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @Override
    public CourseRecyclerAdapter.CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(viewType, parent, false);

        return new CourseViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        return courses.get(position).getLectures() < 15 ? R.layout.list_item_course_left :
                R.layout.list_item_course_right;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course currentCourse = courses.get(position);
        holder.tvCourseName.setText(currentCourse.getName());
        holder.tvTeacherName.setText(currentCourse.getTeacherName());
        holder.tvOnGoing.setText(String.valueOf(currentCourse.isOnGoing()));
        holder.tvLectureCount.setText(String.valueOf(currentCourse.getLectures()));

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeacherName, tvCourseName, tvOnGoing, tvLectureCount;


        public CourseViewHolder(View itemView) {
            super(itemView);
            tvCourseName = itemView.findViewById(R.id.tvCourseName);
            tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            tvOnGoing = itemView.findViewById(R.id.tvOnGoing);
            tvLectureCount = itemView.findViewById(R.id.tvLectureCount);
        }
    }
}