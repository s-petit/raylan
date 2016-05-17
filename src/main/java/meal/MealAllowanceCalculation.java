package meal;

import annotation.DomainService;
import meal.valueobject.MealInvoice;
import meal.valueobject.MealYearlyScale;

import java.time.LocalDate;

@DomainService
public final class MealAllowanceCalculation {

    public final MealScale mealScale;
    public final MealCostRepository mealCostRepository;

    public MealAllowanceCalculation(MealScale mealScale, MealCostRepository mealCostRepository) {
        this.mealScale = mealScale;
        this.mealCostRepository = mealCostRepository;
    }

    //TODO SPE :doc
    public Integer getDeductibleAmount() {
        MealYearlyScale allowance = mealScale.get(LocalDate.now().getYear());
        MealInvoice mealInvoice = mealCostRepository.get(LocalDate.now());
        if (mealInvoice.amount > allowance.max) {
            return allowance.max;
        }
        return mealInvoice.amount;
    }

    public Integer getDeductedAmount() {
        MealYearlyScale allowance = mealScale.get(LocalDate.now().getYear());
        return getDeductibleAmount() - allowance.min;
    }

    public Integer getNotDeductedAmount() {
        MealInvoice mealInvoice = mealCostRepository.get(LocalDate.now());
        return mealInvoice.amount - getDeductedAmount();
    }

}
