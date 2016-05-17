package meal.valueobject;

import annotation.ValueObject;

@ValueObject
public final class MealAllowance {

    public final MealInvoice mealInvoice;
    public final MealYearlyScale mealYearlyScale;

    public MealAllowance(MealInvoice mealInvoice, MealYearlyScale mealYearlyScale) {
        this.mealInvoice = mealInvoice;
        this.mealYearlyScale = mealYearlyScale;
    }

    public Integer getDeductibleAmount() {
        if (mealInvoice.amount > mealYearlyScale.max) {
            return mealYearlyScale.max;
        }
        return mealInvoice.amount;
    }

    public Integer getDeductedAmount() {
        return getDeductibleAmount() - mealYearlyScale.min;
    }

    public Integer getNotDeductedAmount() {
        return mealInvoice.amount - getDeductedAmount();
    }
}
