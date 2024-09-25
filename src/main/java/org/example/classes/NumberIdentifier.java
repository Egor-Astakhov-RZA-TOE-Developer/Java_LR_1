package org.example.classes;

public class NumberIdentifier {
    private final static String[] ROMAN_NUMBERS_TO_X = new String[] {"I", "II", "III", "IV", "V",
                                                                    "VI", "VII", "VIII", "IX", "X"};
    public static boolean isArabicNumber(String number){
        // Проверка, что все символы String number это цифры
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))){
                return false;
            }
        }
//        return Integer.parseInt(number) <= 10 && Integer.parseInt(number) >= 1;
        return true;
    }
    public static boolean isRomanNumber(String number){
        for (String romanNumber: ROMAN_NUMBERS_TO_X){
            if(number.equals(romanNumber)) return true;
        }
        return false;
    }

    /*public static boolean isRomanNumber(String number){
        // Проверка, что все символы String number это цифры
        // Цикл по всем символам строки
        for (int i = 0; i < number.length(); i++) {
            Character ch = number.charAt(i);
            boolean isRoman = false;

            // цикл по всем символам массива  ROMAN_CHARS
            for (char charRoman: ROMAN_CHARS){
                if (ch.equals(charRoman)) isRoman = true;
            }
            if (!isRoman){
                return false;
            }
        }
        return true;
    }*/

}
