package meal;

import meal.valueobject.MealInvoice;
import meal.valueobject.MealYearlyScale;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Year;

import static org.mockito.Mockito.when;

public class MealAllowanceCalculationTest {

    @InjectMocks
    private MealAllowanceCalculation mealAllowanceCalculation;

    @Mock
    private MealCostRepository mealCostRepository;

    @Mock
    private MealScale mealScale;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deductible_amount_should_be_equal_to_meal_invoice_amount_when_less_than_yearly_max_scale() {
        int minScale = 2;
        Integer maxScale = 10;
        Integer invoiceAmount = 3;
        LocalDate date = LocalDate.now();
        when(mealCostRepository.get(date)).thenReturn(new MealInvoice(invoiceAmount, date));
        when(mealScale.get(date.getYear())).thenReturn(new MealYearlyScale(minScale, maxScale, Year.of(date.getYear())));
        Integer deductibleAmount = mealAllowanceCalculation.getDeductibleAmount();

        AssertionsForInterfaceTypes.assertThat(deductibleAmount).isEqualTo(invoiceAmount);
    }

    @Test
    public void deductible_amount_should_be_equal_to_yearly_max_scale_when_greater_than_yearly_max_scale() {
        int minScale = 2;
        Integer maxScale = 10;
        Integer invoiceAmount = 13;
        LocalDate date = LocalDate.now();
        when(mealCostRepository.get(date)).thenReturn(new MealInvoice(invoiceAmount, date));
        when(mealScale.get(date.getYear())).thenReturn(new MealYearlyScale(minScale, maxScale, Year.of(date.getYear())));
        Integer deductibleAmount = mealAllowanceCalculation.getDeductibleAmount();

        AssertionsForInterfaceTypes.assertThat(deductibleAmount).isEqualTo(maxScale);
    }

    @Test
    public void deductible_amount_should_be_equal_to_yearly_max_scale_when_equal_to_yearly_max_scale() {
        int minScale = 2;
        Integer maxScale = 10;
        Integer invoiceAmount = 10;
        LocalDate date = LocalDate.now();
        when(mealCostRepository.get(date)).thenReturn(new MealInvoice(invoiceAmount, date));
        when(mealScale.get(date.getYear())).thenReturn(new MealYearlyScale(minScale, maxScale, Year.of(date.getYear())));
        Integer deductibleAmount = mealAllowanceCalculation.getDeductibleAmount();

        AssertionsForInterfaceTypes.assertThat(deductibleAmount).isEqualTo(maxScale);
    }
/*
    @Test
    public void deductible_amount_should_be_equal_to_0_when_less_than_yearly_min_scale() {
        int minScale = 2;
        Integer maxScale = 10;
        Integer invoiceAmount = 1;
        LocalDate date = LocalDate.now();
        when(mealCostRepository.get(date)).thenReturn(new MealInvoice(invoiceAmount, date));
        when(mealScale.get(date.getYear())).thenReturn(new MealYearlyScale(minScale, maxScale, Year.of(date.getYear())));
        Integer deductibleAmount = mealAllowanceCalculation.getDeductibleAmount();

        AssertionsForInterfaceTypes.assertThat(deductibleAmount).isEqualTo(0);
    }

    @Test
    public void deductible_amount_should_be_equal_to_0_when_equal_to_yearly_min_scale() {
        int minScale = 2;
        Integer maxScale = 10;
        Integer invoiceAmount = 2;
        LocalDate date = LocalDate.now();
        when(mealCostRepository.get(date)).thenReturn(new MealInvoice(invoiceAmount, date));
        when(mealScale.get(date.getYear())).thenReturn(new MealYearlyScale(minScale, maxScale, Year.of(date.getYear())));
        Integer deductibleAmount = mealAllowanceCalculation.getDeductibleAmount();

        AssertionsForInterfaceTypes.assertThat(deductibleAmount).isEqualTo(0);
    }*/
}