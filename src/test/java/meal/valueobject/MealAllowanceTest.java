package meal.valueobject;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Year;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MealAllowanceTest {

    @Test
    public void deductible_amount_should_be_equal_to_meal_invoice_amount_when_less_than_yearly_max_scale() {
        MealInvoice mealInvoice = new MealInvoice(3, LocalDate.now());
        MealYearlyScale mealYearlyScale = new MealYearlyScale(2, 10, Year.now());
        MealAllowance mealAllowance = new MealAllowance(mealInvoice, mealYearlyScale);

        assertThat(mealAllowance.getDeductibleAmount()).isEqualTo(3);
    }

    @Test
    public void deductible_amount_should_be_equal_to_yearly_max_scale_when_greater_than_yearly_max_scale() {
        MealInvoice mealInvoice = new MealInvoice(13, LocalDate.now());
        MealYearlyScale mealYearlyScale = new MealYearlyScale(2, 10, Year.now());
        MealAllowance mealAllowance = new MealAllowance(mealInvoice, mealYearlyScale);

        assertThat(mealAllowance.getDeductibleAmount()).isEqualTo(10);
    }

    @Test
    public void deductible_amount_should_be_equal_to_yearly_max_scale_when_equal_to_yearly_max_scale() {
        MealInvoice mealInvoice = new MealInvoice(10, LocalDate.now());
        MealYearlyScale mealYearlyScale = new MealYearlyScale(2, 10, Year.now());
        MealAllowance mealAllowance = new MealAllowance(mealInvoice, mealYearlyScale);

        assertThat(mealAllowance.getDeductibleAmount()).isEqualTo(10);
    }

}