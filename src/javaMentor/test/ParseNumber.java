package javaMentor.test;

public class ParseNumber {
    public static void parseNumber(String[] value, String separator) throws CalculatorIllegalException {
        int arabicFormat = 0;
        try {
            int number1 = Integer.parseInt(value[0]);
            int number2 = Integer.parseInt(value[1]);
            System.out.println(mathOperation(number1, number2, separator));
            arabicFormat = 1;
        } catch (NumberFormatException e) {}

        if (arabicFormat == 0) {
                int numeral1 = ArabicRoman.romanToArabic(value[0]);
                int numeral2 = ArabicRoman.romanToArabic(value[1]);
                int mathResult = mathOperation(numeral1, numeral2, separator);
            System.out.println(ArabicRoman.arabicToRoman(mathResult));
        }
    }

    public static int mathOperation(int valueNumber1, int valueNumber2, String valueSeparator) throws CalculatorIllegalException {
        if((valueNumber1 > 0 && valueNumber1 <= 10) && (valueNumber2 > 0 && valueNumber2 <= 10)){
            switch (valueSeparator){
                case "+" :
                    return (valueNumber1 + valueNumber2);
                case "-" :
                    return (valueNumber1 - valueNumber2);
                case "*" :
                    return (valueNumber1 * valueNumber2);
                case "/" :
                    return (valueNumber1 / valueNumber2);
            }
        } else {
            throw new CalculatorIllegalException("The numbers are outside the specified range of values [1, 10]");
        }
        return 0;
    }
}
