package meal.valueobject;

import annotation.ValueObject;

@ValueObject
public final class MealAllowance {

    // a voir si on scale une allaownace sur un jour ou sur un mois selon le besoin métier

    public final MealInvoice mealInvoice;
    public final MealYearlyScale mealYearlyScale;

    public MealAllowance(MealInvoice mealInvoice, MealYearlyScale mealYearlyScale) {
        this.mealInvoice = mealInvoice;
        this.mealYearlyScale = mealYearlyScale;
    }

    public Double getAmountToDeduct() {
        if (mealInvoice.amount > mealYearlyScale.max) {
            return mealYearlyScale.max;
        }
        return mealInvoice.amount;
    }

    public Double getDeductedAmount() {
        Double deductibleAmount = getAmountToDeduct();
        if (deductibleAmount < mealYearlyScale.min) {
            return 0.0;
        }
        return deductibleAmount - mealYearlyScale.min;
    }

    public Double getUndeductedAmount() {
        return mealInvoice.amount - getDeductedAmount();
    }
}
