package javaMentor.test;

public class Conversion {

    public static String stringConversion(String a){

        String stringNoSpaces = a.replaceAll(" ", "");
        String stringToUpperCase = stringNoSpaces.toUpperCase();

        return stringToUpperCase;
    }
}
