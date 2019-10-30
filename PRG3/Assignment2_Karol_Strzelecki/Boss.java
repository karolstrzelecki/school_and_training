// Karol Strzelecki id: 19101653
// Boss class derived from Employee.

public final class Boss extends Employee {

    private double weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last, double salary) {
        super(first, last); // call superclass constructor
        setWeeklySalary(salary);
    }

    // Constructor for class Boss which is able to set date when employee joined our company
    public Boss(String first, String last, int year, int month, int day, int hour, int minute,
                double salary) throws InvalidDateException {
        super(first, last, year, month, day, hour, minute); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
    public void setWeeklySalary(double salary) {
        weeklySalary = (salary > 0 ? salary : 0);
    }

    // modified getter of Boss's pay which throws TooLittlePaymentException
    // if the salary is lower than equivalent of 40hours * 10 euro = 400
    public double earnings() throws TooLittlePaymentException {
        if (weeklySalary < 400) { // 400 is equivalent of 40(hours) * 10(euro)
            throw new TooLittlePaymentException(toString() +
                    " earns less than €10 per hour. Your employees should be better paid");
        }
        return weeklySalary;
    }

    // get String representation of Boss's name
    public String toString() {
        return "Boss: " + super.toString();
    }
} // end class Boss
