package ua.com.dfyzok;

public class �urrentDividend {

    public StringBuilder currentDividend;

    public �urrentDividend(StringBuilder currentDividend) {
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
        return "�urrentDividend [currentDividend=" + currentDividend + "]";
    }

}
