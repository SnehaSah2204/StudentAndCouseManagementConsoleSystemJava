package com.airtribe.learntrack.entity;

import static com.airtribe.learntrack.util.AutoIdGenerator.generatedCourseId;

public class Course {
    private int courseId;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public Course(String courseName, String description, int durationInWeeks, boolean active) {
        this.courseId = generatedCourseId();
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public int getId() {
        return courseId;
    }

    public void setId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
