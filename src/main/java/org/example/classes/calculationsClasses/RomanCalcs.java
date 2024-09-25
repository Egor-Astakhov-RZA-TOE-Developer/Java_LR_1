package org.example.classes.calculationsClasses;

import java.util.List;

public class RomanCalcs extends Calculations{
    @Override
    public String addition(String num1, String num2) {
        int result = parseRomanToArabic(num1) + parseRomanToArabic(num2);
        return parseArabicToRoman(result);
    }

    @Override
    public String subtraction(String num1, String num2) {
        int result = parseRomanToArabic(num1) - parseRomanToArabic(num2);
        return result > 0 ? parseArabicToRoman(result) : "неположительный результат" ;
    }


    @Override
    public String multiplication(String num1, String num2) {
        int result = parseRomanToArabic(num1) * parseRomanToArabic(num2);
        return parseArabicToRoman(result);
    }

    @Override
    public String division(String num1, String num2) {
        int result = parseRomanToArabic(num1) / parseRomanToArabic(num2);
        return parseArabicToRoman(result);
    }

    private int parseRomanToArabic(String romanNumber){
        String[] symbols = romanNumber.split("");
        int countOfIbefore = 0, countOfIafter = 0, countOfV = 0, countOfX = 0;
        for (String symbol: symbols){
            if(symbol.equals("I") && countOfV == 0){
                countOfIbefore ++;
            }
            else if (symbol.equals("I")) {
                countOfIafter ++;
            }
            else if (symbol.equals("V")) countOfV++;
            else countOfX++;
        }
        if (countOfV == 0 && countOfX == 0) return countOfIbefore;
        else return 10 * countOfX + 5 * countOfV + countOfIafter - countOfIbefore;
    }
    private String parseArabicToRoman(int romanNumber){
        int decades = romanNumber / 10;

        StringBuilder result = new StringBuilder();

        if (decades == 10) return "С";
        else if (decades > 8) result.append("XC");
        else if (decades >= 5) {
            result.append("L");
            for (int i = 0; i < decades - 5; i++) {
                result.append("X");
            }
        } else if (decades == 4) {
            result.append("XL");
        } else {
            for (int i = 0; i < decades; i++) {
                result.append("X");
            }
        }

        int digits = romanNumber % 10;

        if (digits > 8) result.append("IX");
        else if (digits >= 5) {
            result.append("V");
            for (int i = 0; i < digits - 5; i++) {
                result.append("I");
            }
        } else if (digits == 4) {
            result.append("IV");
        } else {
            for (int i = 0; i < digits; i++) {
                result.append("I");
            }
        }

        return result.toString();
    }
}
