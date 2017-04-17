package drabek.jaroslaw.supplier.toughjet;

import java.math.BigDecimal;

public class PriceCalculator {

    private BigDecimal basePrice;
    private BigDecimal tax = new BigDecimal("0");
    private int discountPercentage = 0;

    public PriceCalculator(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public static PriceCalculator base(BigDecimal basePrice) {
        return new PriceCalculator(basePrice);
    }

    public PriceCalculator tax(BigDecimal tax) {
        this.tax = tax;
        return this;
    }

    public PriceCalculator discount(int discountPercentage) {
//        Preconditions.checkArgument(discountPercentage<=100 & discountPercentage>=0, "");
        this.discountPercentage = discountPercentage;
        return this;
    }

    public BigDecimal calculate() {
        BigDecimal priceWithTax = basePrice.add(tax);
        BigDecimal priceWithDiscount = priceWithTax
                .multiply(new BigDecimal(String.valueOf(100 - discountPercentage)))
                .divide(new BigDecimal(100));
        return priceWithDiscount;
    }
}
