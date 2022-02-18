package ua.com.dfyzok;

public class ÑurrentDividend {

    public StringBuilder currentDividend;

    public ÑurrentDividend(StringBuilder currentDividend) {
        this.currentDividend = currentDividend;
    }

    public StringBuilder getCurrentDividend() {
        return currentDividend;
    }

    public void setCurrentDividend(StringBuilder currentDividend) {
        this.currentDividend = currentDividend;
    }

    @Override
    public String toString() {
        return "ÑurrentDividend [currentDividend=" + currentDividend + "]";
    }

}
