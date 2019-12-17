package nuiggalway.app.my_app;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class Course {

//    A course programme class containing course name (CS and IT or ECE,
//    etc.), list of modules,list of students that are enrolled, academic start
//    date and end date. Start and end dates should use Joda Time classes
//            (i.e.DateTime), which must be added as a project dependency.

    private String courseName;
    private List<Module> modules;
    private List<Student> students;
    private LocalDate startDate;
    private LocalDate endDate;


    public Course(String courseName, List<Module> modules, List<Student> students,
                  int syear, int smonth, int sday, int eyear, int emonth, int eday ) {


        this.courseName = courseName;
        this.modules = modules;
        this.students = students;
        this.startDate = new LocalDate(syear,smonth,sday);
        this.endDate = new LocalDate(eyear, emonth, eday);

    }

    public Course(String courseName, int syear, int smonth, int sday, int eyear, int emonth, int eday ) {


        this.courseName = courseName;
        this.modules = new ArrayList<Module>();
        this.students = new ArrayList<Student>();
        this.startDate = new LocalDate(syear,smonth,sday);
        this.endDate = new LocalDate(eyear, emonth, eday);

    }

    public void addStudent(Student student){
        students.add(student);

    }

    public void addModule(Module module){
        modules.add(module);
    }






}

