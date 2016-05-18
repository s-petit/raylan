package meal.valueobject;

import annotation.ValueObject;

/**
 * A meal allowance represents legal allowance given the year scale and the meal price
 */
@ValueObject
public final class MealAllowance {

    // a voir si on scale une allaownace sur un jour ou sur un mois selon le besoin métier

    public final Double mealPrice;
    public final MealYearlyScale mealYearlyScale;

    public MealAllowance(MealInvoice mealInvoice, MealYearlyScale mealYearlyScale) {
        this.mealPrice = mealInvoice.price;
        this.mealYearlyScale = mealYearlyScale;
    }

    public Double getAmountToDeduct() {
        if (mealPrice > mealYearlyScale.max) {
            return mealYearlyScale.max;
        }
        return mealPrice;
    }

    public Double getDeductedAmount() {
        Double deductibleAmount = getAmountToDeduct();
        if (deductibleAmount < mealYearlyScale.min) {
            return 0.0;
        }
        return deductibleAmount - mealYearlyScale.min;
    }

    public Double getUndeductedAmount() {
        return mealPrice - getDeductedAmount();
    }
}
