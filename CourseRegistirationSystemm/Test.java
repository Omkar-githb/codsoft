package CourseRegistirationSystemm;

import java.rmi.AccessException; 
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        CourseRegistiration registrationSystem = new CourseRegistiration(); 
        initializeCoursesAndStudents(registrationSystem);
        enrollStudentForCourse(registrationSystem, new Scanner(System.in));
    }

    private static void initializeCoursesAndStudents(CourseRegistiration registrationSystem){

        registrationSystem.addCourse("AI1O1", "Artificial Intelligence", "Monday", "10:00"); 
        registrationSystem.addCourse("DS102", "Data Science", "Thursday", "11.00");
        registrationSystem.addCourse("DA103","Data Analytics", "Wednesday", "12.00");
        registrationSystem.addCourse("ML104", "Machine Learning", "Friday", "10:00");
        registrationSystem.addCourse("CC105", "Cloud Computing", "Tuesday", "12:00");
        registrationSystem.addCourse("CS104", "Cyber Security", "Tuesday", "11.00");

        registrationSystem.addStudent(111, "Omkar", "Londhe");
        registrationSystem.addStudent(222, "Swapnil", "Shete");
        registrationSystem.addStudent(333, "Murli", "Sharma");
        registrationSystem.addStudent(444, "Shivam", "Pore");
        registrationSystem.addStudent (666, "Aditya", "Singh");
    }

    private static void enrollStudentForCourse(CourseRegistiration registrationSystem, Scanner scanner){

        System.out.println("------------------------------------------");

        System.out.println("Welcome to the Course Registration System!");

        System.out.println("------------------------------------------");

        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Available Courses ");
            System.out.println("4. Student Course Registration");
            System.out.println("5. Display Registrations");
            System.out.println("6. Student Enroll For Course");
            System.out.println("0. Exit");

    
            System.out.print("\nEnter your choice: "); 
            int choice = scanner.nextInt(); 
            scanner.nextLine();

            switch (choice) { 
                case 1:
            
                    System.out.print("\nEnter Course ID: "); 
                    String courseCode = scanner.nextLine(); 
                    System.out.print("\nEnter Course Name: ");
                    String courseName = scanner.nextLine(); 
                    System.out.print("\nEnter Course Day: ");
                    String days = scanner.nextLine();
                    System.out.print("\nEnter Time: "); 
                    String time = scanner.nextLine();

                    registrationSystem.addCourse(courseCode, courseName, days, time);

                    System.out.println("\nCourse added successfully!");
                    break;

                case 2:

                    System.out.print("\nEnter Student ID: "); 
                    int studentNum = scanner.nextInt();
                    System.out.println("\nEnter Student Name: "); 
                    scanner.nextLine(); 
                    String studentName = scanner.nextLine(); 
                    System.out.println("\nEnter Student Surname: "); 
                    String studentSurname = scanner.nextLine(); 
                    registrationSystem.addStudent(studentNum, studentName, studentSurname);
                    System.out.println("\nStudent added successfully!");
                    break;

                case 3:

                    registrationSystem.displayCourses();
                    break;

                case 4:

                    System.out.print("\nEnter Student ID: "); 
                    studentNum = scanner.nextInt();
                    System.out.print("\nEnter Course ID to enroll:");
                    scanner.nextLine();
                    String enteredcourseCode = scanner.nextLine();
                    try {
                        registrationSystem.registerStudentForCourse(studentNum, enteredcourseCode);  
                    } catch (AccessException e) {
                        e.printStackTrace(); 
                    }
                    break;

                case 5:

                    System.out.print("\nEnter Student ID: ");
                    studentNum = scanner.nextInt();
                    registrationSystem.displayStudentRegistrations (studentNum);
                    break;

                case 6:

                    enrollStudentForCourse(registrationSystem, scanner);
                    break;

                case 0:
                    System.out.println("\nExiting. Goodbye!"); 
                    System.exit(0);

                default:

                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}