package com.company;

/**
 * Created by guyazran on 6/22/15.
 */
public class Fraction extends Number{
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        this.denominator = 1;
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        this.numerator = numerator;
        if (denominator != 0)
            this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int intValue() {
        return numerator/denominator;
    }

    @Override
    public long longValue() {
        return (long)numerator/denominator;
    }

    @Override
    public float floatValue() {
        return (float)numerator/denominator;
    }

    @Override
    public double doubleValue() {
        return (double)numerator/denominator;
    }


}
