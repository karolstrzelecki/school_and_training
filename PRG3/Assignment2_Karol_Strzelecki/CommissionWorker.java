// Karol Strzelecki id 19101653
// CommissionWorker class derived from Employee

public final class CommissionWorker extends Employee {

    private double salary; // base salary per week
    private double commission; // amount per item sold
    private int quantity; // total items sold for week

    // constructor for class CommissionWorker
    public CommissionWorker(String first, String last,
                            double salary, double commission, int quantity) {
        super(first, last); // call superclass constructor
        setSalary(salary);
        setCommission(commission);
        setQuantity(quantity);
    }

    // constructor for class CommissionWorker which is able to set date when employee joined our company

    public CommissionWorker(String first, String last, int year, int month, int day, int hour, int minute,
                            double salary, double commission, int quantity) throws InvalidDateException {
        super(first, last, year, month, day,hour, minute); // call superclass constructor
        setSalary(salary);
        setCommission(commission);
        setQuantity(quantity);
    }


    // set CommissionWorker's weekly base salary
    public void setSalary(double weeklySalary) {
        salary = (weeklySalary > 0 ? weeklySalary : 0);
    }

    // set CommissionWorker's commission
    public void setCommission(double itemCommission) {
        commission = (itemCommission > 0 ? itemCommission : 0);
    }

    // set CommissionWorker's quantity sold
    public void setQuantity(int totalSold) {
        quantity = (totalSold > 0 ? totalSold : 0);
    }


    public double earnings() throws TooLittlePaymentException {
        double cash = salary + commission * quantity;
        if (cash < 400) { // 400 is equivalent of 40(hours) * 10(euro)
            throw new TooLittlePaymentException(toString() +
                    " earns less than €10 per hour, Your employees should be better paid");
        }

        return cash;
    }


    // get String representation of CommissionWorker's name
    public String toString() {
        return "Commission worker: " + super.toString();
    }
} // end class CommissionWorker
