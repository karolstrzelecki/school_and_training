// Karol Strzelecki id: 19101653
// PieceWorker class derived from Employee

public final class PieceWorker extends Employee {

    private double wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last,
                       double wage, int numberOfItems) {
        super(first, last); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }

    // Constructor for class Pieceworker which is able to set date

    public PieceWorker(String first, String last, int year, int month, int day, int hour, int minute,
                       double wage, int numberOfItems) throws InvalidDateException{ // it has to throw InvalidDateException
        super(first, last, year, month, day, hour, minute); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }


    // set PieceWorker's wage
    public void setWage(double wage) {
        wagePerPiece = (wage > 0 ? wage : 0);
    }

    // set number of items output
    public void setQuantity(int numberOfItems) {
        quantity = (numberOfItems > 0 ? numberOfItems : 0);
    }

    // determine PieceWorker's earnings


    // Old earnings method
    //    public double earnings() {
    //        return quantity * wagePerPiece;
    //    }

    // customized earnings method which throws exception
    // i took minimum weekly payment:  40hours * 10 euro = 400euro
    public double earnings() throws TooLittlePaymentException {
        double cash = quantity * wagePerPiece;
        if (cash < 400) { // 400 is equivalent of 40(hours) * 10(euro)
            throw new TooLittlePaymentException(toString() +
                    " earns less than €10 per hour, Your employees should be better paid");
        }

        return cash;
    }

    public String toString() {
        return "Piece worker: " + super.toString();
    }
}
