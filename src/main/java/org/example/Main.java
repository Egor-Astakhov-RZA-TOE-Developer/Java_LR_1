package org.example;

import org.example.classes.NumberIdentifier;
import org.example.classes.calculationsClasses.ArabicCalcs;
import org.example.classes.calculationsClasses.Calculations;
import org.example.classes.calculationsClasses.RomanCalcs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String arithmeticExpression = sc.nextLine().replaceAll("\\s+", "");

        // Разбиваем строку на операнды и математический оператор
        String num1 = "", operation = "", num2;
        StringBuilder stringBuilder = new StringBuilder();
        boolean findMathOperator = false;
        for (int i = 0; i < arithmeticExpression.length(); i++) {
            Character ch = arithmeticExpression.charAt(i);
            if (Character.isDigit(ch) || Character.isAlphabetic(ch) && !findMathOperator){
                stringBuilder.append(ch);
            } else if (Character.isDigit(ch) || Character.isAlphabetic(ch) && findMathOperator) {
                stringBuilder.append(ch);
            } else {
                findMathOperator = true;
                operation = ch.toString();
                num1 = stringBuilder.toString();
                stringBuilder = new StringBuilder();
            }
        }
        num2 = stringBuilder.toString();


        Calculations calculations = null;
        // логический флаг для обозначения корректности ведённых данных
        boolean isCorrect = false;
        if(NumberIdentifier.isArabicNumber(num1) != NumberIdentifier.isArabicNumber(num2)) {
            System.out.println("Неверно введён формат чисел. Оба числа должны быть в арабской или римской системе счисления, и быть не больше 9!");
        }
        else if (NumberIdentifier.isRomanNumber(num1) && NumberIdentifier.isRomanNumber(num2)) {
            calculations = new RomanCalcs();
            isCorrect = true;
        }
        else {
            calculations = new ArabicCalcs();
            isCorrect = true;
        }

        if (isCorrect){
            String result = switch (operation){
                case "+" -> calculations.addition(num1, num2);
                case "-" -> calculations.subtraction(num1, num2);
                case "*" -> calculations.multiplication(num1, num2);
                case "/" -> calculations.division(num1, num2);
                default -> throw new IllegalArgumentException("Задан некорректный математический оператор!");

            };

//            System.out.println("Результат: " + num1 + " " + operation + " " + num2 + " = " + result);
            System.out.println(result);
        }
    }
}