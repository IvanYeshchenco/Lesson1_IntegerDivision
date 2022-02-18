package ua.com.dfyzok;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scannerDidivend = new Scanner(System.in);
        System.out.println("Input our dividend:");

        while (!scannerDidivend.hasNextInt()) {
            System.out.println("Input integer! dividend:");
            scannerDidivend = new Scanner(System.in);
        }
        Integer dividend = scannerDidivend.nextInt();
        dividend = Math.abs(dividend);

        Scanner scannerDivisor = new Scanner(System.in);
        System.out.println("Input our divisor:");

        while (!scannerDivisor.hasNextInt()) {
            System.out.println("Input integer! divisor:");
            scannerDivisor = new Scanner(System.in);
        }

        Integer divisor = scannerDivisor.nextInt();
        divisor = Math.abs(divisor);
        if (divisor == 0) {
            throw new IllegalArgumentException("Error! Divisor is 0");
        }
        System.out.println("The result of dividing your numbers:");

        Divide makeDivision = new Divide();
        List<DivisionResult> divisionResult = makeDivision.makeIntegerDivision(dividend, divisor);

        ResultPrinter resultFormation = new ResultPrinter();
        String result = resultFormation.prepareResult(dividend, divisor, divisionResult);
        System.out.println(result);
    }
}
