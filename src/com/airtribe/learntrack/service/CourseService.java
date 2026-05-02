package com.airtribe.learntrack.service;

import static com.airtribe.learntrack.util.IntegerInputValidator.checkIfInteger;

import java.util.ArrayList;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {

    public Course addCourse(Scanner sc) {
        System.out.println("===Welcome to adding a new course ===");
        System.out.println("Enter Course Name");
        String courseName = sc.nextLine();
        System.out.println("Enter Course Description");
        String courseDescription = sc.nextLine();
        System.out.println("Enter Course Duration in Weeks");
        int courseDuration = checkIfInteger(sc);
        sc.nextLine();
        return (new Course(courseName, courseDescription, courseDuration, true));
    }

    public void displayAllCourses(ArrayList<Course> courses) {
        if (!courses.isEmpty()) {
            System.out.println("AIRTRIBE COURSES");
            System.out.println();

            for (Course course : courses) {
                System.out.println("Course Id: " + course.getId());
                System.out.println("Course Name: " + course.getCourseName());
                System.out.println("Description: " + course.getDescription());
                System.out.println("Course Duration: " + course.getDurationInWeeks());
                System.out.println("Course Is Active Status: " + course.getActive());
                System.out.println();
            }
            System.out.println("===End of Courses===");
        } else {
            throw new EntityNotFoundException("No Courses to display : No records found");
        }
    }

    public void changeCourseActiveStatus(int id, ArrayList<Course> courses) {
        if (!courses.isEmpty()) {
            boolean found = false;
            for (Course course : courses) {
                if (id == course.getId()) {
                    System.out.println("Changing active status of course " + course.getId() + " " + course.getCourseName());
                    course.setActive((course.getActive() == true) ? false : true);
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println("The given Course id does not match a course");

        } else {
            throw new EntityNotFoundException("No Courses to display : No records found");
        }
    }
}
