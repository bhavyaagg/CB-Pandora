package me.bhavyaaggarwal.listviewswithmemoryhandling.models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bhavyaaggarwal on 17/12/17.
 */

public class Course {
    String name;
    String teacherName;
    int lectures;
    boolean onGoing;

    public Course(String name, String teacherName, int lectures, boolean onGoing) {
        this.name = name;
        this.teacherName = teacherName;
        this.lectures = lectures;
        this.onGoing = onGoing;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getLectures() {
        return lectures;
    }

    public boolean isOnGoing() {
        return onGoing;
    }


    static final String[] sampleTeachers = {
            "Prateek", "Deepak", "Garima", "Rishab", "Arnav", "Aayush", "Harshit"
    };

    static final String[] sampleCourses = {
            "Pandora", "Elixir", "Launchpad", "Crux", "Perceptron",
            "Gamedev", "Competitive Coding", "Algo++"
    };

    public static ArrayList<Course> genRandCourses(int num) {
        ArrayList<Course> courses = new ArrayList<>(num);
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            courses.add(new Course(
                    sampleCourses[r.nextInt(8)],
                    sampleTeachers[r.nextInt(7)],
                    10 + r.nextInt(10),
                    r.nextBoolean()
            ));
        }
        return courses;
    }
}
