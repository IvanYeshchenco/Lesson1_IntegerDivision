package ua.com.dfyzok;

public class DivisionResult {

    public int dividend;
    public int multiplicationProduct;
    public int remainer;

    DivisionResult(int dividend, int multiplicationProduct, int remainer) {
        this.dividend = dividend;
        this.multiplicationProduct = multiplicationProduct;
        this.remainer = remainer;

    }

    public int getDividend() {
        return this.dividend;
    }

    public int getMultiplicationProduct() {
        return this.multiplicationProduct;
    }

    public int getRemainer() {
        return this.remainer;
    }

    @Override
    public String toString() {
        return "DivisionResult [dividend=" + dividend + ", multiplicationProduct=" + multiplicationProduct
                + ", remainer=" + remainer + "]";
    }

}
