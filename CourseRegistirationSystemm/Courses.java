package CourseRegistirationSystemm;

public class Courses 
{
    private String courseCode; 
    private String courseName;
    private String days; 
    private String time;
    private int numOfStudents;

    public Courses(String courseCode, String courseName, String days, String time){

        this.courseCode = courseCode;
        this.courseName = courseName; 
        this.days = days;
        this.time = time;
        this.numOfStudents = 0;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) { 
        this.days = days;
    }

    public String getCourseCode() { 
        return courseCode;
    }

    public void setCourseCode(String courseCode) { 
        this.courseCode = courseCode;
    }

    public String getCourseName() { 
        return courseName;
    }

    public void setCourseName(String courseName) {  
        this.courseName = courseName;
    }

    public String getTime() { 
        return time;
    }

    public void setTime(String time) { 
        this.time = time;
    }

    public void incrementNumOfStudents(){
        numOfStudents++;
    }

    public Courses() {
    }
}