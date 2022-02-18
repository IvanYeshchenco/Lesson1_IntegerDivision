package ua.com.dfyzok;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ResultPrinterTest {

    @Test
    void divideIntegerShouldReturnAnswerWhenInputDividendAndDivisor() {
        int dividend = 1235;
        int divisor = 12;
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        divisionResult.add(new DivisionResult(12, 12, 0));
        divisionResult.add(new DivisionResult(0, 0, 0));
        divisionResult.add(new DivisionResult(35, 24, 11));
        ResultPrinter resultFormation = new ResultPrinter();
        String result = resultFormation.prepareResult(dividend, divisor, divisionResult);
        String resultExpected = ("_1235|12\n 12  |---\n --  |102\n  _35\n   24\n   --\n   11");
        Assert.assertEquals(resultExpected, result);
    }

    @Test
    void divideIntegerShouldReturnAnswerWhenInputDividendSameDivisor() {
        int dividend = 8;
        int divisor = 8;
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        divisionResult.add(new DivisionResult(8, 8, 0));
        ResultPrinter resultFormation = new ResultPrinter();
        String result = resultFormation.prepareResult(dividend, divisor, divisionResult);
        String resultExpected = ("_8|8\n 8|-\n -|1\n 0");
        Assert.assertEquals(resultExpected, result);
    }

    @Test
    void divideIntegerShouldReturnAnswerWhenInputDividendAndDivisorIsOne() {
        int dividend = 4;
        int divisor = 1;
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        divisionResult.add(new DivisionResult(4, 4, 0));
        ResultPrinter resultFormation = new ResultPrinter();
        String result = resultFormation.prepareResult(dividend, divisor, divisionResult);
        String resultExpected = ("_4|1\n 4|-\n -|4\n 0");
        Assert.assertEquals(resultExpected, result);
    }
}
