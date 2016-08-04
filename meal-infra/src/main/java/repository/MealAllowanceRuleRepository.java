package repository;

import meal.AllowanceRule;
import meal.valueobject.MealYearlyScale;

/**
 * Meal Allowance : frais de repas
 * Repositories sur les regles métier de frais de repas
 */
public class MealAllowanceRuleRepository implements AllowanceRule {

    private static final double MIN_SCALE_2016 = 4.7;
    private static final double MAX_SCALE_2016 = 18.3;

    @Override
    public MealYearlyScale get(int year) {
        return new MealYearlyScale(MIN_SCALE_2016, MAX_SCALE_2016, year);
    }
}
