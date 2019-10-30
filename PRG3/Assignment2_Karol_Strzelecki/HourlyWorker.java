// Karol Strzelecki id: 19101653
// Definition of class HourlyWorker

public final class HourlyWorker extends Employee  {

    private double wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last,
                        double wagePerHour, double hoursWorked) {
        super(first, last); // call superclass constructor
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // constuctor for class HourlyWorker which allows us to change the date when our employee
    // joined our company
    public HourlyWorker (String first, String last, int year, int month, int day, int hour, int minute,
                        double wagePerHour, double hoursWorked) throws InvalidDateException {
       super(first, last, year, month, day, hour, minute);

       // call superclass overloaded constructor which allows to change date of hire
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // Set the wage
    public void setWage(double wagePerHour) {
        wage = (wagePerHour > 0 ? wagePerHour : 0);
    }

    // Set the hours worked
    public void setHours(double hoursWorked) {
        hours = (hoursWorked >= 0 && hoursWorked < 168
                ? hoursWorked : 0);
    }

    // Modified earnings() method which throws TooLittlePaymentException when our employee
    // earns less than equivalent of 40hours * 10 euro (minimal weekly payment)
    public double earnings() throws TooLittlePaymentException {
        double cash = wage * hours;
        if (cash < 400) { // 400 is equivalent of 40(hours) * 10(euro)
            throw new TooLittlePaymentException(toString() +
                    " earns less than €10 per hour, Your employees should be better paid");
        }

        return cash;
    }


    public String toString() {
        return "Hourly worker: " + super.toString();
    }
}

