// Karol Strzelecki id: 19101653

package com.assignment4;

import java.text.DecimalFormat;

public class Rational {
    private int p;
    private  int q;


    // constructor


    public Rational(int p, int q) throws DivideByZeroException {
        if (q == 0){
            throw new DivideByZeroException("q equals zero");
        }
        this.p = p;
        this.q = q;
    }


    // recursive algorithym method which search greatest common divisor (Euclid's Algorythym)
    // it uses modulo operations on numbers
    // if we modulo 20(x) and 8(y), y not equals zero, so recurrently
    // giving y as first argument, and modulo from 20 and 8 so the reminder is 4
    // we have 4 reminder, then we modulo 8(y) and 4 (reminder) and we get 0
    // so our functions returns 4 (greatest divisor)
        private static int euclids (int x, int y){
        if (y == 0) return x;
        else return euclids(y, x%y);

        }

        public Rational simplify(){
            int gd = euclids(p,q);
            int x = p/gd;
            int y = q/gd;

            try {
                return new Rational(x,y);
            } catch (DivideByZeroException e) {
                e.printStackTrace();
            } return null;


        }

        // Arithmetic methods

        public Rational multiply(Rational tmp){
            try {
                return new Rational(this.p *  tmp.p, this.q * tmp.q);
            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            } return null;
        }

        public Rational divide(Rational tmp){
            try {
                return this.multiply(new Rational(tmp.q, tmp.p));
            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            } return null;
        }

        public Rational plus(Rational tmp){
        int p = (this.p * tmp.q) + (this.q * tmp.p);
        int q = this.q * tmp.q;
            try {
                return new Rational(p,q);
            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            } return null;
        }

        public Rational minus(Rational tmp){
            int p = (this.p * tmp.q) - (this.q * tmp.p);
            int q = this.q * tmp.q;
            try {
                return new Rational(p,q);
            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            } return null;
        }

        //===== toString method


    public String toDecimal(){

        DecimalFormat precision = new DecimalFormat("0.00");
        double tmp = p/(double)q;
        return precision.format(tmp);
    }

    public String toString() {
        if (q ==1) return p + "";
        else return p +"/" + q;
        }


    }

