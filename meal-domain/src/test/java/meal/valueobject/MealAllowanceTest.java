package meal.valueobject;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MealAllowanceTest {

    @Test
    public void deductible_amount_should_be_equal_to_meal_invoice_amount_when_less_or_equal_than_yearly_max_scale() {
        MealAllowance mealAllowance = buildMealAllowance(3, LocalDate.now(), 2, 10);
        assertThat(mealAllowance.getAmountToDeduct()).isEqualTo(3);
    }

    @Test
    public void deductible_amount_should_be_equal_to_yearly_max_scale_when_greater_than_yearly_max_scale() {
        MealAllowance mealAllowance = buildMealAllowance(13, LocalDate.now(), 2, 10);
        assertThat(mealAllowance.getAmountToDeduct()).isEqualTo(10);
    }

    @Test
    public void should_compute_deducted_amount() {
        MealAllowance mealAllowance = buildMealAllowance(10, LocalDate.now(), 2, 15);
        assertThat(mealAllowance.getDeductedAmount()).isEqualTo(8);
    }

    @Test
    public void deducted_amount_should_be_zero_when_meal_amount_is_less_than_min_scale() {
        MealAllowance mealAllowance = buildMealAllowance(4, LocalDate.now(), 5, 15);
        assertThat(mealAllowance.getDeductedAmount()).isEqualTo(0);
    }

    @Test
    public void not_deducted_amount_should_be_equal_to_min_scale_when_amount_is_less_than_max_scale() {
        MealAllowance mealAllowance = buildMealAllowance(14, LocalDate.now(), 5, 15);
        assertThat(mealAllowance.getUndeductedAmount()).isEqualTo(5);
    }

    @Test
    public void should_compute_not_deducted_amount_when_meal_amount_is_greater_than_max_scale() {
        MealAllowance mealAllowance = buildMealAllowance(18, LocalDate.now(), 5, 15);
        assertThat(mealAllowance.getUndeductedAmount()).isEqualTo(8);
    }

    private MealAllowance buildMealAllowance(double amount, LocalDate date, double minScale, double maxScale) {
        MealInvoice mealInvoice = new MealInvoice(amount, date);
        MealYearlyScale mealYearlyScale = new MealYearlyScale(minScale, maxScale, date.getYear());
        return new MealAllowance(mealInvoice, mealYearlyScale);
    }

}