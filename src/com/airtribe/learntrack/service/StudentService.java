package com.airtribe.learntrack.service;

import static com.airtribe.learntrack.util.EmailValidate.getValidEmail;

import java.util.ArrayList;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentService {

    public Student addStudent(Scanner sc) {
        System.out.println("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name: ");
        String lastName = sc.nextLine();
        String email = getValidEmail(sc);
            System.out.println("Enter Batch: ");
            String batch = sc.nextLine();
            return (new Student(firstName, lastName, email, batch, true));
    }

    public void displayStudents(ArrayList<Student> students) {
        if (!students.isEmpty()) {
            System.out.println();
            System.out.println("====== Displaying All Students ======");
            for (Student s : students) {
                System.out.println("Id: " + s.getId());
                System.out.println("First Name: " + s.getFirstName());
                System.out.println("Last Name: " + s.getLastName());
                System.out.println("Email: " + s.getEmail());
                System.out.println("Batch: " + s.getBatch());
                System.out.println("Is an active Student: " + s.getActive());
                System.out.println("---------------------------------------");
                System.out.println();
            }
            System.out.println("================== End Of Students List ==========================");
        } else {
            throw new EntityNotFoundException("No Students to display : No Records founds");
        }
    }

    public Student searchStudent(int id, ArrayList<Student> students) {
        if (!students.isEmpty()) {
            boolean found=false;
            for (Student s : students) {
                if (s.getId() == id) {
                    found=true;
                    return s;
                }
            }
            if(!found)
                System.out.println("Student with the given id not found");
        } else {
            throw new EntityNotFoundException("No Students to display : No Records founds");
        }
        return null;
    }

    public Student searchStudent(String email, ArrayList<Student> students) {
        if (!students.isEmpty()) {
            boolean found=false;
            for (Student s : students) {
                if (s.getEmail().equals(email)) {
                    found=true;
                    return s;
                }
            }
            if(!found)
                System.out.println("Student with the given email not found");
        } else {
            throw new EntityNotFoundException("No Students to display : No Records founds");
        }
        return null;
    }

    public void deactivateStudentById(int id, ArrayList<Student> students) {
        if (!students.isEmpty()) {
            boolean found =false;
            for (Student s : students) {
                if (s.getId() == id) {
                    s.setActive(false);
                    System.out.println();
                    System.out.println("Student with id: " + s.getId() + " Name: " + s.getFirstName() +" "+ s.getLastName() + " is no more an active user");
                    System.out.println();
                    found=true;
                    break;
                }
            }
            if(!found){
            System.out.println("Student not found");
            System.out.println();}
        } else {
            System.out.println();
            throw new EntityNotFoundException("No Students to display : No Records founds");
        }
    }
}
