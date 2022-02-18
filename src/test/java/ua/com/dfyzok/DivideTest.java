package ua.com.dfyzok;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DivideTest {

    @Test
    void divideShouldReturnRemainerWhenInputDividendAndDivisor() {
        int dividend = 12350;
        int divisor = 121;
        int Actual = dividend - (dividend / divisor * divisor);
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        Divide makeDivision = new Divide();
        divisionResult = makeDivision.makeIntegerDivision(dividend, divisor);
        int lengthList = divisionResult.size();
        int resultExpected = divisionResult.get(lengthList - 1).getRemainer();
        Assert.assertEquals(resultExpected, Actual);
    }

    @Test
    void divideShouldReturnMultiplicationProductWhenInputDividendAndDivisor() {
        int dividend = 12350;
        int divisor = 121;
        int Actual = 121;
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        Divide makeDivision = new Divide();
        divisionResult = makeDivision.makeIntegerDivision(dividend, divisor);
        int resultExpected = divisionResult.get(0).getMultiplicationProduct();
        Assert.assertEquals(resultExpected, Actual);
    }

    @Test
    void divideShouldReturnDividendWhenInputDividendAndDivisor() {
        int dividend = 12350;
        int divisor = 1212;
        int Actual = 1235;
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        Divide makeDivision = new Divide();
        divisionResult = makeDivision.makeIntegerDivision(dividend, divisor);
        int resultExpected = divisionResult.get(0).getDividend();
        Assert.assertEquals(resultExpected, Actual);
    }

    @Test
    void divideShouldReturnZeroWhenInputZeroDividendAndDivisor() {
        int dividend = 0;
        int divisor = 5;
        int Actual = 0;
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        Divide makeDivision = new Divide();
        divisionResult = makeDivision.makeIntegerDivision(dividend, divisor);
        int resultExpected = divisionResult.get(0).getRemainer();
        Assert.assertEquals(resultExpected, Actual);
    }

    @Test
    void divideShouldReturnDividendWhenInputOneDividendAndDivisor() {
        int dividend = 1;
        int divisor = 5;
        int Actual = 1;
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        Divide makeDivision = new Divide();
        divisionResult = makeDivision.makeIntegerDivision(dividend, divisor);
        int resultExpected = divisionResult.get(0).getRemainer();
        Assert.assertEquals(resultExpected, Actual);
    }

    @Test
    void divideShouldReturnDividendWhenInputSameDividendAndDivisor() {
        int dividend = 8;
        int divisor = 8;
        int Actual = 0;
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        Divide makeDivision = new Divide();
        divisionResult = makeDivision.makeIntegerDivision(dividend, divisor);
        int resultExpected = divisionResult.get(0).getRemainer();
        Assert.assertEquals(resultExpected, Actual);
    }

    @Test
    void divideShouldReturnRemainerWhenInputDividendAndBigDivisor() {
        int dividend = 12350;
        int divisor = 12121;
        int Actual = 229;
        List<DivisionResult> divisionResult = new ArrayList<DivisionResult>();
        Divide makeDivision = new Divide();
        divisionResult = makeDivision.makeIntegerDivision(dividend, divisor);
        int resultExpected = divisionResult.get(0).getRemainer();
        Assert.assertEquals(resultExpected, Actual);
    }
}
