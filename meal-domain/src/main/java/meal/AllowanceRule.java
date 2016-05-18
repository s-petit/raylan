package meal;

import meal.valueobject.MealYearlyScale;

public interface AllowanceRule {
    MealYearlyScale get(int year);
}
