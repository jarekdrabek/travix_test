package drabek.jaroslaw.supplier.toughjet;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static drabek.jaroslaw.supplier.toughjet.PriceCalculator.base;

public class PriceCalculatorTest {

    @Test
    public void should_calculate_with_default_tax_and_discount(){
        //when
        BigDecimal finalPrice = base(new BigDecimal("150")).calculate();
        //then
        Assertions.assertThat(finalPrice).isEqualTo(new BigDecimal("150"));
    }

    @Test
    public void should_calculate_tax(){
        //when
        BigDecimal finalPrice = base(new BigDecimal("150")).tax(new BigDecimal("50")).calculate();
        //then
        Assertions.assertThat(finalPrice).isEqualTo(new BigDecimal("200"));
    }

    @Test
    public void should_calculate_tax_and_cound_discount(){
        //when
        BigDecimal finalPrice = base(new BigDecimal("150")).tax(new BigDecimal("50")).discount(20).calculate();
        //then
        Assertions.assertThat(finalPrice).isEqualTo(new BigDecimal("160"));
    }

    @Test
    public void should_calculate_tax_and_cound_100_percentage_discount(){
        //when
        BigDecimal finalPrice = base(new BigDecimal("150")).tax(new BigDecimal("50")).discount(100).calculate();
        //then
        Assertions.assertThat(finalPrice).isEqualTo(new BigDecimal("0"));
    }

    @Test
    public void should_calculate_tax_and_cound_0_percentage_discount(){
        //when
        BigDecimal finalPrice = base(new BigDecimal("150")).tax(new BigDecimal("50")).discount(0).calculate();
        //then
        Assertions.assertThat(finalPrice).isEqualTo(new BigDecimal("200"));
    }

    @Test
    public void should_calculate_zero_price(){
        //when
        BigDecimal finalPrice = base(new BigDecimal("0")).tax(new BigDecimal("0")).discount(0).calculate();
        //then
        Assertions.assertThat(finalPrice).isEqualTo(new BigDecimal("0"));
    }

    @Test
    public void should_calculate_zero_tax(){
        //when
        BigDecimal finalPrice = base(new BigDecimal("100")).tax(new BigDecimal("0")).discount(0).calculate();
        //then
        Assertions.assertThat(finalPrice).isEqualTo(new BigDecimal("100"));
    }

}