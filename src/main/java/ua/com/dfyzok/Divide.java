package ua.com.dfyzok;

import java.util.ArrayList;
import java.util.List;

public class Divide {

    public List<DivisionResult> makeIntegerDivision(Integer inputDividend, Integer inputDivisor) {
        List<DivisionResult> divisionResults = new ArrayList<DivisionResult>();
        String dividendString = String.valueOf(inputDividend);
        StringBuilder currentDividendString = new StringBuilder();
        final int lengthCalculatedResult = calculateLength(inputDividend / inputDivisor);
        final int lengthDividend = calculateLength(inputDividend);

        currentDividendString.append(dividendString.charAt(0));
        ÑurrentDividend currentDividend = new ÑurrentDividend(currentDividendString);
        DivisionStep cycleStep = new DivisionStep(0, 1);
        int i = cycleStep.getIndex();
        int dividendIndex = cycleStep.getDividendIndex();

        while (i < lengthDividend || dividendIndex < lengthDividend) {
            appendStep(cycleStep, currentDividend, dividendString, inputDivisor, lengthDividend, lengthCalculatedResult,
                    divisionResults);
            i = cycleStep.getIndex();
            dividendIndex = cycleStep.getDividendIndex();
        }
        return divisionResults;
    }

    private List<DivisionResult> appendStep(DivisionStep cycleStep, ÑurrentDividend currentDividend,
            String dividendString, Integer inputDivisor, int lengthDividend, int lengthCalculatedResult,
            List<DivisionResult> divisionResults) {

        int currentDividendIndex = cycleStep.getDividendIndex();
        combineDividend(cycleStep, currentDividend, dividendString, inputDivisor, currentDividendIndex, lengthDividend);

        StringBuilder currentDividendString = currentDividend.getCurrentDividend();
        Integer currentDividendInt = converteToInt(currentDividend);
        int multiplicationProduct = currentDividendInt / inputDivisor * inputDivisor;
        int remainer = currentDividendInt % inputDivisor;
        recordResults(currentDividendInt, multiplicationProduct, remainer, divisionResults);

        currentDividendString = new StringBuilder();
        currentDividendString.append(remainer);
        currentDividend.setCurrentDividend(currentDividendString);

        int lengthDivisor = calculateLength(inputDivisor);
        int currentIndex = cycleStep.getIndex();
        if (checkForDivisionPass(remainer, currentIndex, lengthDividend, currentDividendIndex, lengthDivisor)) {
            skipDivisionStep(lengthDivisor, lengthCalculatedResult, divisionResults);
        }
        currentIndex++;
        cycleStep.setIndex(currentIndex);
        return divisionResults;
    }

    private void combineDividend(DivisionStep cycleStep, ÑurrentDividend currentDividend, String dividendString,
            Integer inputDivisor, int currentDividendIndex, int lengthDividend) {
        StringBuilder currentDividendString = currentDividend.getCurrentDividend();
        Integer currentDividendInt = converteToInt(currentDividend);
        while (checkLengthDividend(currentDividendInt, inputDivisor, currentDividendIndex, lengthDividend)) {
            int currentIndex = cycleStep.getIndex();
            currentDividendString.append(dividendString.charAt(currentDividendIndex));
            currentDividend.setCurrentDividend(currentDividendString);
            currentDividendIndex++;
            currentDividendInt = converteToInt(currentDividend);
            cycleStep.setDividendIndex(currentDividendIndex);
            currentIndex++;
            cycleStep.setIndex(currentIndex);
        }
    }

    private List<DivisionResult> recordResults(Integer currentDividendInt, int multiplicationProduct, int remainer,
            List<DivisionResult> divisionResults) {
        divisionResults.add(new DivisionResult(currentDividendInt, multiplicationProduct, remainer));
        return divisionResults;
    }

    private List<DivisionResult> skipDivisionStep(int lengthDivisor, int lengthCalculatedResult,
            List<DivisionResult> divisionResults) {
        int n = 1;
        while (checkForSkipDivisionPass(n, lengthDivisor, lengthCalculatedResult, divisionResults)) {
            divisionResults.add(new DivisionResult(0, 0, 0));
            n++;
        }
        return divisionResults;
    }

    private boolean checkLengthDividend(int currentDividend, int inputDivisor, int dividendIndex, int lengthDividend) {
        return (currentDividend < inputDivisor) && (dividendIndex < lengthDividend);
    }

    private boolean checkForDivisionPass(int remainer, int i, int lengthDividend, int dividendIndex,
            int lengthDivisor) {
        return (remainer == 0 && i > 0 && i < lengthDividend && dividendIndex < lengthDividend && lengthDivisor > 1);
    }

    private boolean checkForSkipDivisionPass(int n, int lengthDivisor, int lengthCalculatedResult,
            List<DivisionResult> divisionResults) {
        return (n < lengthDivisor && divisionResults.size() + 1 < lengthCalculatedResult);
    }

    private int calculateLength(Integer input) {
        return String.valueOf(input).length();
    }

    private Integer converteToInt(ÑurrentDividend input) {
        StringBuilder inputString = input.getCurrentDividend();
        return Integer.parseInt(inputString.toString());
    }
}
