package javaMentor.test;

import java.util.List;

public class ArabicRoman {

    public static int romanToArabic(String line){
        int result = 0;
        int tempCnt = 0;
        int countRepeat = 0;
        List<RomanNumeral> romanNumeralList = RomanNumeral.getValuesRomanNumeral();

        while((line.length() > 0) && (tempCnt < romanNumeralList.size())) {
            RomanNumeral symbol = romanNumeralList.get(tempCnt);
            if(line.startsWith(symbol.name()) && countRepeat < 3) {
                result += symbol.getValue();
                line = line.substring(symbol.name().length());
                countRepeat ++;
            } else {
                tempCnt ++;
                countRepeat = 0;
            }
        }
     if(line.length() > 0) {
         throw new IllegalArgumentException("The characters are neither Arabic nor Roman numbers at the same time.");
     }
       return result;
    }

    public static String arabicToRoman(int num) {

        if((num <= 0) || (num > 4000)) {
            throw new IllegalArgumentException(num + " is not in range valid Roman numerals (0, 4000)");
        }

        List<RomanNumeral> romanNumeralList = RomanNumeral.getValuesRomanNumeral();
        int tempCnt = 0;
        StringBuilder result = new StringBuilder();

        while((num > 0) && (tempCnt < romanNumeralList.size())){
            RomanNumeral currentSymbol = romanNumeralList.get(tempCnt);
            if(currentSymbol.getValue() <= num) {
                result.append(currentSymbol.name());
                num -= currentSymbol.getValue();
            } else {
                tempCnt ++;
            }
        }
        return result.toString();
    }
}
