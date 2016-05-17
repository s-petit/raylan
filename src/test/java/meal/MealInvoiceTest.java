package meal;

import meal.valueobject.MealInvoice;
import org.junit.Test;

import java.time.LocalDate;

public class MealInvoiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_amount_is_negative() {
        new MealInvoice(-1, LocalDate.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_amount_is_zero() {
        new MealInvoice(0, LocalDate.now());
    }
}