package CourseRegistirationSystemm;

import java.util.ArrayList;

public class Students 
{

  private int studentNum;
  private String studentName; 
  private String studentSurname;
  ArrayList<Courses> courseList = new ArrayList<>();

  public int getNumOfCourses() {
    return courseList. size();
  }

  public void registerCourse(Courses course) {
    courseList.add(course);
  }

  public int getStudentNum() {
    return studentNum;
  }

  public void setStudentNum(int studentNum) { 
    this.studentNum = studentNum;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentSurname() { 
    return studentSurname;
  }

  public void setStudentSurname (String studentSurname) {
    this.studentSurname = studentSurname;
  }
 
  public ArrayList<Courses> getCourseList() {
    return courseList;
  }

  public void setCourseList(ArrayList<Courses> courseList) {
    this.courseList = courseList;
  }

/**
 * @param studentNum
 * @param studentName
 * @param studentSurname
 */

  public Students(int studentNum, String studentName, String studentSurname) {
    this.studentNum = studentNum;
    this.studentName = studentName;
    this.studentSurname = studentSurname;
    this.courseList = new ArrayList<>();
  }

  public Students() {
  }
}