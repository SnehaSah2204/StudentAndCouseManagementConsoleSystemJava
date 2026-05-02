package com.airtribe.learntrack.service;

import static com.airtribe.learntrack.util.IntegerInputValidator.checkIfInteger;

import java.util.ArrayList;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class EnrollmentService {
    public Enrollment enrollStudent(Scanner sc, ArrayList<Student> students, ArrayList<Course> courses) {
        System.out.println("===Enroll a student===");
        System.out.println("Enter Student Id: ");
        int studentId = checkIfInteger(sc);
        sc.nextLine();
        boolean studentExists = students.stream().anyMatch(s->s.getId()==studentId);
        if(studentExists) {
            System.out.println("Enter Course ID: ");
            int courseId = checkIfInteger(sc);
            sc.nextLine();
            boolean courseExists = courses.stream().anyMatch(c->c.getId()==courseId);
            if(courseExists) {
                System.out.println("Enter Enrollment Date in DD/MM/YY/ :");
                String date = sc.nextLine();
                System.out.println("Enter Enrollment Status: \"Active\", \"Completed\" , \"Cancelled\"");
                String status = sc.next();
                System.out.println();
                return (new Enrollment(studentId, courseId, date, status));
            }
            else {
                throw new EntityNotFoundException("No Course with the given id found");
            }}
        else{
            throw new EntityNotFoundException("No Student with the given id found");
        }}

    public void viewEnrollmentsOfStudent(ArrayList<Enrollment> enrollments, int studentId) {
        if (!enrollments.isEmpty()) {
            boolean found = false;
            for (Enrollment enrollment : enrollments) {
                if (enrollment.getStudentId() == studentId) {
                    found = true;
                    System.out.println();
                    System.out.println("Enrollment id: " + enrollment.getId());
                    System.out.println("Student id: " + enrollment.getStudentId());
                    System.out.println("Course id: " + enrollment.getCourseId());
                    System.out.println("Course Date: " + enrollment.getEnrollmentDate());
                    System.out.println("Active Status: " + enrollment.getStatus());
                    System.out.println();
                }
            }
            if (!found)
                System.out.println("Student with the given id not found");
        } else {
            throw new EntityNotFoundException("No enrollments done yet : No Records Found");
        }
    }

    public void changeEnrollmentStatus(ArrayList<Enrollment> enrollments, int studentId, String status) {
        if (!enrollments.isEmpty()) {
            boolean found = false;
            for (Enrollment enrollment : enrollments) {
                if (enrollment.getStudentId() == studentId) {
                    found = true;
                    enrollment.setStatus(status);
                    System.out.println();
                    System.out.println("Status of Student with id " + enrollment.getStudentId() + " successfully changed to " + status);
                    System.out.println();
                    break;
                }
            }
            if (!found)
                System.out.println("Student with given id not Found");
        } else {
            throw new EntityNotFoundException("No enrollments done yet : No Records Found");
        }
    }
}
