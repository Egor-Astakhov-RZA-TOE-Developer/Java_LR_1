package org.example.classes.calculationsClasses;

public class ArabicCalcs extends Calculations{
    @Override
    public String addition(String num1, String num2) {
        return Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2));
    }

    @Override
    public String subtraction(String num1, String num2) {
        return Integer.toString( Integer.parseInt(num1) - Integer.parseInt(num2));
    }

    @Override
    public String multiplication(String num1, String num2) {
        return Integer.toString(Integer.parseInt(num1) * Integer.parseInt(num2));
    }

    @Override
    public String division(String num1, String num2) {
        return Integer.toString(Integer.parseInt(num1) / Integer.parseInt(num2));
    }
}
