package meal;

import meal.valueobject.MealInvoice;
import meal.valueobject.MealYearlyScale;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

public class MealAllowanceCalculationTest {

    @InjectMocks
    private MealAllowanceCalculation mealAllowanceCalculation;

    @Mock
    private MealAccounting mealAccounting;

    @Mock
    private AllowanceRule allowanceRule;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_compute_not_deductible_total_for_a_given_month() {
        MealYearlyScale scale2016 = new MealYearlyScale(2.5, 20.0, 2016);
        MealInvoice februaryInvoice1 = new MealInvoice(15.5, LocalDate.of(2016, Month.FEBRUARY, 1));
        MealInvoice februaryInvoice2 = new MealInvoice(20.5, LocalDate.of(2016, Month.FEBRUARY, 2));

        YearMonth feb2016 = YearMonth.of(2016, Month.FEBRUARY);
        when(mealAccounting.get(feb2016)).thenReturn(Arrays.asList(februaryInvoice1, februaryInvoice2));
        when(allowanceRule.get(2016)).thenReturn(scale2016).thenReturn(scale2016);

        Double undeductedTotal = mealAllowanceCalculation.getUndeductedTotal(feb2016);
        assertThat(undeductedTotal).isEqualTo(5.5);
    }
}