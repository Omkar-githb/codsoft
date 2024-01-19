package CourseRegistirationSystemm;

import java.rmi.AccessException; 
import java.util.ArrayList;

public class CourseRegistiration
{

  private ArrayList <Courses> courses = new ArrayList<>();
  private ArrayList <Students> students = new ArrayList<>();


  public ArrayList<Courses> getCourses() { 
    return courses;
  }

  public void setCourses(ArrayList<Courses> courses) { 
    this.courses = courses;
  }

  public ArrayList<Students> getStudents() { 
    return students;
  } 

  public void setStudents(ArrayList<Students> students) { 
    this.students = students;
  }

  public CourseRegistiration() {
  
  } 

  public void registerStudentForCourse(int studentNum, String courseCode) throws AccessException {

    Students student = getStudentById(studentNum); 
    Courses course = getCourseById(courseCode);

    if (student != null && course != null) { 
      if (canRegisterForCourse(student, course) && !hasScheduleConflict(student, course)) {

        student.registerCourse(course); 
        course. incrementNumOfStudents();
        System.out.println("Registration successful!"); 
      } 
      else {

        System.out.println("Unable to register for the course. Please check he rules!");
      }
    } 
    else {

      System.out.println("Invalid student ID or course ID, Please try again.");
    }
  }

  private boolean canRegisterForCourse(Students student, Courses course) { 
    return course != null && course.getNumOfStudents() < 5 && student.getNumOfCourses() < 5;
  }

  private boolean hasScheduleConflict(Students student, Courses newCourse) {
    for (Courses course : student.getCourseList()) {
      if (course.getDays().equals(newCourse.getDays())) { 
        return true;
      }
    }   
    return false;
  }

  public void addCourse(String CourseCode, String CourseName, String days, String time){
    courses.add(new Courses(CourseCode, CourseName, days, time));
  }

  public void addStudent(int studentNum, String studentName, String studentSurname){
    students.add(new Students(studentNum, studentName, studentSurname));
  }

  public void displayCourses() {
    System.out.println("Available Courses:");
    for (Courses course : courses) {
      System.out.println(course.getCourseCode() + " - " + course.getCourseName() + " - " + course.getDays() + " - " + course.getTime());
    }
    System.out.println();
  }

  public void displayStudentRegistrations(int studentNum) {
   Students student = getStudentById(studentNum);
    if  (student != null) {
      System.out.println("Registered Courses for " + student.getStudentName() + student.getStudentSurname() + ":");

      for (Courses course :  student.getCourseList()) { 
        System.out.println(course.getCourseCode() + " - " + course.getCourseName());
      }
    } 
    else {

      System.out.println("Invalid student ID. Please try again.");
    }
  }

  private Students getStudentById(int studentNum) {

    for (Students student : students) { 
      if (student.getStudentNum() == (studentNum)) {
        return student;
      }
    }
    return null;
  }

  private Courses getCourseById(String courseCode) { 
    for (Courses course : courses) {
      if (course.getCourseCode().equals(courseCode)) {
        return course;
      }
    }
    return null;
  }
}
