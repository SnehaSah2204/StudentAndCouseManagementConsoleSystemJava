1) Why you used ArrayList instead of array
ArrayList was used instead of array here because:
- I used ArrayList because the number of students, courses, and enrollments is not fixed.In a console management application, admins can add new records dynamically, so ArrayList automatically grows when new items are added.This is easier and safer than using an array, which would require a predefined size and manual resizing.
- ArrayList has more predefined methods, making it easier to add, remove, list elements which array does not.
- ArrayList has dynamic size in nature , while in array, we need to define a fixed size.
- In arrayList we can perform easy insertion and deletions as compared to array.

2) Where you used static members and why?

Static methods:
- Main.class : For the main method

AutoIdGenerator class in util:

Static Methods:
- generatedStudentId
- generatedCourseId
- generatedEnrollmentId

Static Variables:

- studentId - 
- enrollmentId- 
- courseId-

Why: I wanted a single value of counters to be maintained and shared by all objects. Each time a new student is created, or enrollment is created or a course is added, a common counter generates the id.

IntegerInputValidator class in util:
Static Method:
checkIfInteger(Scanner sc)

Why? 
Made this static to be directly called and shared, not object specific, maintaining one copy to check if a the was input is valid integer or not.

EmailValidate class in util:
Static Variable: EMAIL_REGEX : 
Static Method: 
-isValid(String email)
-getValidEmail(Scanner sc)

why?
Email validation is again a common utility that can be used anywhere without an object.

3) Where you used inheritance and what you gained from it

- Student class extends from Person
- Trainer class also extends from person
- Inheritance is used with Person as the base/parent class and Student/Trainer as subclasses.

Person class has feilds id, first name , last name and email. 

With making Person as the Parent class for student and trainer, I did not have to redefine the same fields for them, reducing duplicate code and getting a cleaner design with code reuse.
I was also able to implement method overloading using this.
