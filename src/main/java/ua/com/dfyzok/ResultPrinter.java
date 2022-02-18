package ua.com.dfyzok;

import java.util.List;

public class ResultPrinter {

    public String prepareResult(Integer dividend, Integer divisor, List<DivisionResult> divisionResult) {
        final int resultsCount = divisionResult.size();
        final int lengthDividend = calculateLength(dividend);
        final int result = dividend / divisor;
        final int resultLength = calculateLength(dividend / divisor);
        StringBuilder resultText = new StringBuilder();
        appendFirstLine(dividend, divisor, resultText);
        for (int i = 0; i < resultsCount; i++) {
            appendStep(divisionResult, lengthDividend, result, resultLength, resultText, i);
        }
        appendRemainder(resultText, resultsCount, lengthDividend, divisionResult);
        return resultText.toString();
    }

    private void appendFirstLine(int dividend, int divisor, StringBuilder resultText) {
        resultText.append("_").append(dividend).append("|").append(divisor + "\n");
    }

    private void appendStep(List<DivisionResult> divisionResult, int lengthDividend, int result, int resultLength,
            StringBuilder resultText, int i) {
        DivisionResult currentResult = divisionResult.get(i);
        int lengthDividendNow = calculateLength(currentResult.getDividend());
        int lengthMultiplicationProducts = calculateLength(currentResult.getMultiplicationProduct());
        if (i == 0) {
            appendFirstStep(resultText, divisionResult, lengthDividendNow, lengthDividend, lengthMultiplicationProducts,
                    resultLength, result);
        } else if (currentResult.getDividend() != 0) {
            DivisionResult previousStepResult = divisionResult.get(i - 1);
            DivisionResult olderStepResult = i < 2 ? divisionResult.get(i - 1) : divisionResult.get(i - 2);
            appendRegularStep(i, resultText, lengthDividend, lengthDividendNow, lengthMultiplicationProducts,
                    previousStepResult, currentResult, olderStepResult);
        }
    }

    private void appendRemainder(StringBuilder resultText, int lengthList, int lengthDividend,
            List<DivisionResult> result) {
        int lengthRemainer = calculateLength(result.get(lengthList - 1).getRemainer());
        addGap(resultText, lengthDividend - lengthRemainer + 1);
        resultText.append(result.get(lengthList - 1).getRemainer());
    }

    private void appendFirstStep(StringBuilder resultText, List<DivisionResult> result, int lengthDividendNow,
            int lengthDividend, int lengthMultiplicationProducts, int lengthexpectedResult, int expectedResult) {
        int lengthGap = lengthDividendNow - lengthMultiplicationProducts;
        addGap(resultText, lengthGap + 1);
        resultText.append(result.get(0).getMultiplicationProduct());
        addGap(resultText, lengthDividend - lengthMultiplicationProducts - lengthGap);
        resultText.append("|");
        addDash(resultText, lengthexpectedResult);
        resultText.append("\n");
        addGap(resultText, lengthGap + 1);
        addDash(resultText, lengthMultiplicationProducts);
        addGap(resultText, lengthDividend - lengthMultiplicationProducts - lengthGap);
        resultText.append("|").append(expectedResult).append("\n");
    }

    private void appendRegularStep(int index, StringBuilder resultText, int lengthDividend, int lengthDividendNow,
            int lengthMultiplicationProducts, DivisionResult oldStepResult, DivisionResult currentResult,
            DivisionResult olderDivisionResult) {
        int gap = calculateGap(index, lengthDividend, oldStepResult, olderDivisionResult);
        int extraIndentation = (lengthDividendNow > lengthMultiplicationProducts) ? 1 : 0;
        int gapForDividend = gap - 1;
        addGap(resultText, gapForDividend);
        resultText.append("_").append(currentResult.getDividend()).append("\n");
        addGap(resultText, gap + extraIndentation);
        resultText.append(currentResult.getMultiplicationProduct()).append("\n");
        addGap(resultText, gap);
        addDash(resultText, lengthDividendNow);
        resultText.append("\n");
    }

    private int calculateGap(int index, int lengthDividend, DivisionResult oldStepResult,
            DivisionResult olderDivisionResult) {
        int lengthRemainerLast = calculateLength(oldStepResult.getRemainer());
        int lengthDividendLast = calculateLength(oldStepResult.getDividend());
        int remainderLast = oldStepResult.getRemainer();
        boolean checkForDivisionPass = checkForDivisionPass(lengthRemainerLast, lengthDividendLast, remainderLast);
        int olderRemainder = olderDivisionResult.getRemainer();
        boolean gapCondition = (lengthDividend < 3 && index < 2) ? checkForDivisionPass
                : (checkForDivisionPass || olderRemainder != 0);
        return gapCondition ? index : index + 1;
    }

    private static StringBuilder addDash(StringBuilder input, int strick) {
        for (int i = 0; i < strick; i++) {
            input.append("-");
        }
        return input;
    }

    private static StringBuilder addGap(StringBuilder input, int strick) {
        for (int i = 0; i < strick; i++) {
            input.append(" ");
        }
        return input;
    }

    private int calculateLength(Integer input) {
        return String.valueOf(input).length();
    }

    private boolean checkForDivisionPass(int lengthRemainerLast, int lengthDividendLast, int remainerLast) {
        return (lengthRemainerLast == lengthDividendLast && remainerLast != 0);

    }
}
