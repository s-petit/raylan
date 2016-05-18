package meal;

import annotation.DomainService;
import meal.valueobject.MealAllowance;
import meal.valueobject.MealInvoice;
import meal.valueobject.MealYearlyScale;

import java.time.YearMonth;
import java.util.List;

@DomainService
public final class MealAllowanceCalculation {

    public final AllowanceRule allowanceRule;
    public final MealAccounting mealAccounting;

    public MealAllowanceCalculation(AllowanceRule allowanceRule, MealAccounting mealAccounting) {
        this.allowanceRule = allowanceRule;
        this.mealAccounting = mealAccounting;
    }

    public Double getUndeductedTotal(YearMonth yearMonth) {
        MealYearlyScale scale = allowanceRule.get(yearMonth.getYear());
        List<MealInvoice> invoices = mealAccounting.get(yearMonth);

        return invoices.stream()
                .mapToDouble(mealInvoice -> new MealAllowance(mealInvoice, scale).getUndeductedAmount())
                .sum();
    }
}
