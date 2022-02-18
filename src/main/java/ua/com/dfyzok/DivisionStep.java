package ua.com.dfyzok;

public class DivisionStep {
    public int index;
    public int dividendIndex;

    DivisionStep(int index, int dividendIndex) {
        this.index = index;
        this.dividendIndex = dividendIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDividendIndex() {
        return dividendIndex;
    }

    public void setDividendIndex(int dividendIndex) {
        this.dividendIndex = dividendIndex;
    }

}
