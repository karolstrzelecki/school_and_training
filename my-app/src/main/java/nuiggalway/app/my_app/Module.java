package nuiggalway.app.my_app;

import java.util.ArrayList;
import java.util.List;

public class Module {

//    A module class, which should contain information such as module name,
//    id(e.g. CT417), list of students, courses it is associated with).

    private String moduleName;
    private String id;
    private List<Student> students;
    private List<Course> courses;


    public Module(String moduleName, String id, List<Student> students, List<Course> courses) {
        this.moduleName = moduleName;
        this.id = id;
        this.students = students;
        this.courses = courses;
    }


    public Module(String moduleName, String id) {
        this.moduleName = moduleName;
        this.id = id;
        this.students = new ArrayList<Student>();
        this.courses = new ArrayList<Course>();
    }

    public void addStudent(Student student){
        students.add(student);

    }

    public void addCourses(Course course){
        courses.add(course);

    }

    //bla bla bla bla bnla
}