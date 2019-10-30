// Karol Strzelecki id: 19101653

package com.assignment4;

import static com.assignment4.Ball.*;


public class Main {

    public static void main(String[] args) throws DivideByZeroException {

        // Printing out Ball enum data

        System.out.println("===== Assignment 4 =====\n");
        System.out.println("\n===== print out of enum ===== \n");

        for (Ball b : Ball.values() ){
            System.out.println(b);
        }


        // printing out methods which contain Ball enum

        System.out.println("\n===== print out of the circumference and the volume =====\n");
        System.out.println("the circumference of Golf ball is: " + GOLF.getCircumference() + " mm");
        System.out.println("the volume of Baseball ball is: " + BASEBALL.getVolume() + " mm^3");

    // 3. Testing Rational

        Rational r1 = new Rational(BASEBALL.getWeight(), BASKETBALL.getWeight());
        Rational r2 = new Rational(FOOTBALL.getWeight(), GOLF.getWeight());
        Rational r3 = new Rational(POOL.getSize(), SOFTBALL.getSize());
        Rational r4 = new Rational(TENNIS.getSize(), VOLLEYBALL.getSize());


        System.out.println("\n===== Testing Rational Class Calculations ===== \n");

        //        15/40

        System.out.println(new Rational(15,40) + " = "
        +new Rational(15,40).simplify() + " = " + new Rational(15,40).toDecimal());


        //        r1 + r2

        System.out.println("("+ r1 + ") + (" + r2 +") = " + r1.plus(r2).simplify() + " = " + r1.plus(r2).toDecimal() );

        //        r2 – r3

        System.out.println("("+ r2 + ") - (" + r3 +") = " + r2.minus(r3).simplify() + " = " + r2.minus(r3).toDecimal());

        //        r3 * r4

        System.out.println("("+ r3 + ") * (" + r4 +") = " + r3.multiply(r4).simplify() + " = "  + r3.multiply(r4).toDecimal());

        //        r4 / r1

        System.out.println("("+ r4 + ") + (" + r1 +") = "  + r4.divide(r1).simplify() + " = " + r4.divide(r1).toDecimal());

        // example with denominator = 0

        //System.out.println(new Rational(12, 0 ));

    }
}
