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

    // TODO SPE: méthode à privatiser, renommer
    public Double getDeductibleAmount() {
        if (mealInvoice.amount > mealYearlyScale.max) {
            return mealYearlyScale.max;
        }
        return mealInvoice.amount;
    }

    public Double getDeductedAmount() {
        Double deductibleAmount = getDeductibleAmount();
        if (deductibleAmount < mealYearlyScale.min) {
            return 0.0;
        }
        return deductibleAmount - mealYearlyScale.min;
    }

    public Double getUndeductibleAmount() {
        return mealInvoice.amount - getDeductedAmount();
    }
}
