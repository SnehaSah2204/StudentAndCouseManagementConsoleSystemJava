package com.airtribe.learntrack.util;

public final class AutoIdGenerator {
    private static int studentId=1;
    private static int courseId= 1;
    private static int enrollmentId=1;

    public static int generatedStudentId(){
        return studentId++;
    }

    public static int generatedCourseId(){
        return courseId++;
    }

    public static int generatedEnrollmentId(){
        return enrollmentId++;
    }

}
