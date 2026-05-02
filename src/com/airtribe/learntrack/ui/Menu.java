package com.airtribe.learntrack.ui;

import static com.airtribe.learntrack.util.EmailValidate.isValid;
import static com.airtribe.learntrack.util.IntegerInputValidator.checkIfInteger;

import java.util.ArrayList;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

public class Menu {
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        StudentService studentService = new StudentService();
        EnrollmentService enrollmentService = new EnrollmentService();
        CourseService courseService = new CourseService();

        do {
            System.out.println("====================================================");
            System.out.println("Welcome to Airtribe Learner Management System ");
            System.out.println("=====================================================");
            System.out.println("Press 1: To go to the Student portal");
            System.out.println("Press 2: TO go to the Enrollments portal");
            System.out.println("Press 3: TO go for Course Management");
            System.out.println("Press any other key to exit the portal");
            System.out.println("=====================================");
            System.out.println("Enter your Choice :  ");
//            choice = checkIfInteger(sc)
//            sc.nextLine();
            try {
                choice = Integer.parseInt(sc.nextLine());
                int studentChoice = 0;
                int enrollmentChoice = 0;
                int courseChoice = 0;
                if (choice == 1) {
                    while (studentChoice < 5) {
                        System.out.println(" Press 1 : To Add new student");
                        System.out.println(" Press 2 : To View all students");
                        System.out.println(" Press 3 : To Search student by ID or email");
                        System.out.println(" Press 4 : To Deactivate a student");
                        System.out.println(" Press any other number to exit");
                        System.out.println();
                        System.out.println(" Enter your choice");
                        studentChoice = checkIfInteger(sc);
                        sc.nextLine();
                        switch (studentChoice) {
                            case 1: {
                                Student newStudent = studentService.addStudent(sc);
                                students.add(newStudent);
                                System.out.println("New Student Added");
                                break;
                            }
                            case 2: {
                                try {
                                    studentService.displayStudents(students);
                                    break;
                                } catch (EntityNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }
                            case 3: {
                                try {
                                    System.out.println();
                                    System.out.println("Enter the id/email of the student");
                                    String idOrEmail = sc.nextLine();
                                    Student s = new Student();
                                    if (isValid(idOrEmail)) {
                                        s = studentService.searchStudent(idOrEmail, students);
                                    } else if (idOrEmail.matches("\\d+")) {
                                        int id = Integer.parseInt(idOrEmail);
                                        s = studentService.searchStudent(id, students);
                                    } else {
                                        System.out.println("Invalid input");
                                    }

                                    if (s != null) {
                                        System.out.println("Student Found with id : " + s.getId());
                                        System.out.println("Name: " + s.getFirstName() + " " + s.getLastName());
                                        System.out.println("Email: " + s.getEmail());
                                        System.out.println("Batch: " + s.getBatch());
                                        System.out.println("Is an active Student: " + s.getActive());
                                        System.out.println();
                                        break;
                                    } else {
                                        System.out.println();
                                        break;
                                    }
                                } catch (EntityNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }
                            case 4: {
                                try {
                                    System.out.println("Enter the id of the student to be deactivated");
                                    int id = checkIfInteger(sc);
                                    sc.nextLine();
                                    studentService.deactivateStudentById(id, students);
                                    break;
                                } catch (EntityNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }
                            default: {
                                if (studentChoice == 0)
                                    studentChoice = 5;
                                System.out.println("Exiting Student Portal");
                            }
                        }
                    }
                } else if (choice == 2) {
                    while (enrollmentChoice < 4) {
                        System.out.println("============================================");
                        System.out.println("Welcome to the Enrollment Portal");
                        System.out.println("============================================");
                        System.out.println(" Press 1 : To Enroll a student in a course");
                        System.out.println(" Press 2 : To View enrollment for a student");
                        System.out.println(" Press 3 : To Mark enrollment as completed/cancelled");
                        System.out.println(" Press any other number to exit");
                        System.out.println("============================================");
                        System.out.println();
                        System.out.println(" Enter your choice");
                        enrollmentChoice = checkIfInteger(sc);
                        System.out.println();
                        switch (enrollmentChoice) {
                            case 1: {
                                try {
                                    Enrollment enrollment = enrollmentService.enrollStudent(sc, students, courses);
                                    enrollments.add(enrollment);
                                    System.out.println("New Student enrolled  ");
                                    System.out.println();
                                    break;
                                } catch (EntityNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }
                            case 2: {
                                try {
                                    System.out.println("Enter the id of the student to view their enrollment");
                                    int id = checkIfInteger(sc);
                                    sc.nextLine();
                                    enrollmentService.viewEnrollmentsOfStudent(enrollments, id);
                                    break;
                                } catch (EntityNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }
                            case 3: {
                                try {
                                    System.out.println("Enter the id of the student to change their status");
                                    int id = checkIfInteger(sc);
                                    sc.nextLine();
                                    System.out.println("Enter the new Status of the student : \"Completed\", \"In Progress\" , \"Cancelled\" ");
                                    String newStatus = sc.nextLine();
                                    enrollmentService.changeEnrollmentStatus(enrollments, id, newStatus);
                                    break;
                                } catch (EntityNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }
                            default: {
                                if (enrollmentChoice == 0) {
                                    enrollmentChoice = 5;
                                    System.out.println("Exiting Enrollment Portal");
                                }
                            }
                        }
                    }

                } else if (choice == 3) {
                    while (courseChoice < 4) {
                        System.out.println("Welcome to the Course Management");
                        System.out.println(" Press 1 : TO Add new course");
                        System.out.println(" Press 2 : To View all courses");
                        System.out.println(" Press 3 : To Activate/Deactivate a course");
                        System.out.println(" Press any other number to exit");
                        System.out.println(" Enter your choice");
                        courseChoice = checkIfInteger(sc);
                        sc.nextLine();
                        switch (courseChoice) {
                            case 1: {
                                Course course = courseService.addCourse(sc);
                                courses.add(course);
                                System.out.println("Course added with details : " + course);
                                break;
                            }
                            case 2: {
                                try {
                                    courseService.displayAllCourses(courses);
                                    break;
                                } catch (EntityNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }
                            case 3: {
                                try {
                                    System.out.println("Enter the id of the course to change their status");
                                    int id = checkIfInteger(sc);
                                    sc.nextLine();
                                    courseService.changeCourseActiveStatus(id, courses);
                                    break;
                                } catch (EntityNotFoundException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                            }
                            default: {
                                if (courseChoice == 0) {
                                    courseChoice = 5;
                                    System.out.println("Exiting Courses Portal");
                                }
                               
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Thank you for your time!");
                choice=0;
            }
        } while (choice != 0 && choice<4);

    }
}

