// Karol Strzelecki Id: 19101653
// Abstract base class Employee.
// I am really sorry for my English language, but I am only Erasmus Student


import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

public abstract class Employee  {

    private String firstName;
    private String lastName;
    private LocalDateTime joinDate;
    private int id; // We need non- static value which will store current id of each Employee
    private static int tmpId = 1; // Creating static variable which will store current id


    // constructor (joinDate = current day)
    public Employee(String first, String last) {
        firstName = first;
        lastName = last;
        id = tmpId++; // id becomes current tmpId and then Incrementation
        joinDate = new LocalDateTime().now();
    }
    // constructor which allows to change joinDate variable

    public Employee (String first, String last, int year, int monthOfYear, int dayOfMonth, int hour, int minute) throws InvalidDateException{



        String givenDate = dayOfMonth + "/"+ monthOfYear + "/" + year +" " + hour+ ":" +minute;
        firstName = first;
        lastName = last;
        id = tmpId++; // id becomes current tmpId and then Incrementation
            if (monthOfYear>12) {
                throw new InvalidDateException(toString() + givenDate +" is invalid! \n Reason: Month is out of Range");
            }
                LocalDate tmpDate= new LocalDate(year, monthOfYear, 1);
            // temporary LocalDate is made to count how many days have the month according to year (february)
            if (tmpDate.dayOfMonth().withMaximumValue().getDayOfMonth() < dayOfMonth ){
                throw new InvalidDateException(toString() + givenDate +" is invalid! \n Reason: Day of Month is out of Range");
            }
        // This stands  before declaration of joinDate variable because given variable could cause exception from Joda Library
        joinDate = new LocalDateTime(year, monthOfYear, dayOfMonth, hour, minute);
            if (new LocalDateTime().now().isBefore(joinDate)){
                throw new InvalidDateException(toString() + givenDate +  " is invalid! \n Reason: employee joined us in the future");
            }
            if (year<1990){
                throw new InvalidDateException(toString() + givenDate +" is invalid! \n Reason: employee joined us before 1990");
                }

            if (hour < 9 || hour >=18){
                throw new InvalidDateException(toString() + givenDate +" is invalid! \n Reason: Hiring hours aren't between 9 and 18 ");
            }
            if (joinDate.dayOfWeek().get() > 5) {
                throw new InvalidDateException(toString() + givenDate + " is invalid! \n Reason: We are closed at weekends ");
            }



    }



    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    // get join date

    public int getYears() {
//        return joinDate.minusYears(new LocalDate().now().getYear()).getYear();
        LocalDate now = new LocalDate().now();
        return now.minusYears(joinDate.getYear()).getYear();

    }


    public String toString() {
        return " id. " + id + ". " + firstName + ' ' + lastName+ ' ';
    }

    public abstract double earnings() throws TooLittlePaymentException;
}
