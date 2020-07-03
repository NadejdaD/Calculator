package javaMentor.test;

import java.util.ArrayList;
import java.util.List;

public class Check {

    public static String oneMathOperator(String a) throws CalculatorIllegalException {
        String[] operators = {"+", "-", "*", "/"};
        List<Integer> indexOfOperators = new ArrayList<>();
        String separator = "";

        for (int i = 0; i < operators.length; i++) {
            for (int j = 0; j < operators.length; j++) {
                if (j != i) {
                    indexOfOperators.add(j);
                }
            }
            if (a.contains(operators[i]) && !a.contains(operators[indexOfOperators.get(0)]) && !a.contains(operators[indexOfOperators.get(1)]) && !a.contains(operators[indexOfOperators.get(2)])) {
                separator = operators[i];
                return separator;
            }
            indexOfOperators.clear();
        }
        throw new CalculatorIllegalException("Incorrect data.");
    }

    public static void onlyOneMathOperator(String a, String separator) throws CalculatorIllegalException {
        if(a.indexOf(separator) != a.lastIndexOf(separator)){
            throw new CalculatorIllegalException("Incorrect data.");
        }
    }

    public static String[] gettingNumbers(String a, String separator){
        String[] operands = new String[2];
        int indexSeparator = a.indexOf(separator);

        String value1 = a.substring(0, indexSeparator);
        String value2 = a.substring(indexSeparator + 1);
        operands[0] = value1;
        operands[1] = value2;
        return operands;
    }

}
