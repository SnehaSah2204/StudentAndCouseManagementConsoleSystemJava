# StudentAndCouseManagementConsoleSystemJava

- This is a console-based Student and Course Management System built in Core Java.
- It lets an admin manage students, courses, and enrollments from a text menu.

What it does:

- Add new students with name, email, batch, and active status.
- View all students.
- Search a student by ID or email.
- Deactivate a student instead of deleting.
- Add new courses with name, description, duration, and active status.
- View all courses.
- Activate or deactivate a course.
- Enroll a student in a course with enrollment date and status.
- View enrollments for a student.
- Change enrollment status to Active, Completed, or Cancelled.

How to compile and run
To compile the program :

- Open a terminal in the src folder.
- Run: javac com/airtirbe/learntrack/ui/Menu.java

To run the program:
-run the Menu class from com.airtirbe.learntrack.ui

Class diagram in simple text:

- Person is the parent class for Student and Trainer.
- We have three entities:
  Student --- Enrollment --- Course

Main menu Navigates to the below as per user's choice:
-Menu -> StudentService
-Menu -> CourseService
-Menu -> EnrollmentService

- StudentService service class for Student
- CourseService service class for Course
- EnrollmentService service class for Enrollment

Utilities used:

- AutoIdGenerator for shared ID counters
- EmailValidate for email checks
- IntegerInputValidator for numeric input validation

Additional notes:

- Uses ArrayList because data size is dynamic.
- Uses static helpers for shared utilities and ID generation.
- Uses inheritance so Student and Trainer reuse Person fields.
- Docs include setup instructions, JVM basics, and design notes.
