package javaMentor.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws CalculatorIllegalException, IOException {

        Description.printDescription();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {

                String inputString = reader.readLine();

                String arithmeticExpression = Conversion.stringConversion(inputString);
                if (arithmeticExpression.isEmpty()) {
                    throw new CalculatorIllegalException("String cannot be empty!");
                }

                String separator = Check.oneMathOperator(arithmeticExpression);

                Check.onlyOneMathOperator(arithmeticExpression, separator);

                String[] values = Check.gettingNumbers(arithmeticExpression, separator);

                ParseNumber.parseNumber(values, separator);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            reader.close();
        }
    }
}
