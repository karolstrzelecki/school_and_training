// Karol Strzelecki id: 19101653
// Driver for Employee hierarchy

// Java core packages
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// Java extension packages
import javax.swing.JOptionPane;

public class Test {

    // test Employee hierarchy
    public static void main(String args[]) {

        String output = "";
        List<Employee> employees = new ArrayList<Employee>();




        // ====== First screenshot =======
//
//        try {
//            Boss boss = new Boss("John", "Smith", 1985, 6, 30, 13, 12, 800.0);
//            employees.add(boss);
//        }catch(InvalidDateException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            CommissionWorker commissionWorker =  new CommissionWorker("Sue", "Jones",2020, 8, 4, 10, 23, 400.0, 3.0, 150);
//        employees.add(commissionWorker);
//        }catch(InvalidDateException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            PieceWorker pieceWorker = new PieceWorker("Bob", "Lewis", 1996, 2, 29, 9, 35,  2.5, 200);
//            employees.add(pieceWorker);
//        }catch(InvalidDateException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            HourlyWorker hourlyWorker = new HourlyWorker("Karen", "Price", 2010, 13, 9, 14, 45, 13.75, 40);
//            employees.add(hourlyWorker);
//        }catch(InvalidDateException ex) {
//            System.out.println(ex.getMessage());
//        }

        // ====== Second Screenshot ======

//        try {
//            Boss boss = new Boss("John", "Smith", 2008, 10, 27, 8, 33 , 800.0);
//            employees.add(boss);
//        }catch(InvalidDateException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            CommissionWorker commissionWorker =  new CommissionWorker("Sue", "Jones", 2003, 1, 18, 11, 14 ,400.0, 3.0, 150);
//            employees.add(commissionWorker);
//        }catch(InvalidDateException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            PieceWorker pieceWorker = new PieceWorker("Bob", "Lewis", 1999, 2, 30, 16, 11, 2.5, 200);
//            employees.add(pieceWorker);
//        }catch(InvalidDateException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            HourlyWorker hourlyWorker = new HourlyWorker("Karen", "Price", 2015, 7, 8, 18, 37 ,13.75, 40);
//            employees.add(hourlyWorker);
//        }catch(InvalidDateException ex) {
//            System.out.println(ex.getMessage());
//        }

        // ====== Third Screenshot ======
        // I didn't know if they should catch exception both of those two exception // sorry for my english
        // Program catch only first exception thrown in Employee throwing constructor


        try {
            Boss boss = new Boss("John", "Smith", 1989, 12, 12, 19, 25, 800.0);
            employees.add(boss);
        }catch(InvalidDateException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            CommissionWorker commissionWorker =  new CommissionWorker("Sue", "Jones", 2019, 2, 29, 3, 40 , 400.0, 3.0, 150);
            employees.add(commissionWorker);
        }catch(InvalidDateException ex) {
            System.out.println(ex.getMessage());
        }





        DecimalFormat precision2 = new DecimalFormat("0.00");





        output += "\n TEST \n\n";

    //     loop which adds to  output data of workers

        for (int i = 0; i < employees.size() ; i++ ) {
                    output += employees.get(i).toString() +"\n";
                }
        JOptionPane.showMessageDialog(null, output,
                "Exceptions",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
} // end class Test
