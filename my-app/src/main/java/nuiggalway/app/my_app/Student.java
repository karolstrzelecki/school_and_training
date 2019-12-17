package nuiggalway.app.my_app;

import org.joda.time.LocalDate;
import org.joda.time.Years;


import java.util.ArrayList;
import java.util.List;

public class Student {

    //    A student class should contain some attribute ssuch as (Name, Age, DOB,
//    ID, username, courses and modules registered for, etc.).A specific method
//            (getUsername()) will generate the student’s username by concatenating
//    their name and age.
    private static int incrementCounter = 10000;
    private int id;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<Course> courses;
    private List<Module> modules;

    public Student(String firstName, String lastName, int year, int month, int day) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = new LocalDate(year, month, day);
        this.courses = new ArrayList<Course>();
        this.modules = new ArrayList<Module>();

        incrementIdNum();
        incrementCounter++;
    }


    public void incrementIdNum() {
        setIdNum(incrementCounter);
    }


    public void setIdNum(int idNum) {
        this.id = idNum;
    }



    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public long getAge() {

        LocalDate startDate = getDateOfBirth();
        LocalDate nowDate = new LocalDate();





        if ((startDate != null) && (nowDate != null)) {





            Years years = Years.yearsBetween(startDate, nowDate);
            long age = years.getYears();

            return age;
        } else {
            return 0;
        }


    }


    public String getUserName(){
        String username = this.firstName+this.lastName+ this.getAge();

        return username;

    }


    public void addCourses(Course course) {
        this.courses.add(course);

    }

    public void addModules(Module module){
        this.modules.add(module);

    }

    public List<Module> getModules(){
        return this.modules;
    }

    public List<Course> getCourses() {
        return courses;
    }
}



