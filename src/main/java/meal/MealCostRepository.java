package meal;

import meal.valueobject.MealInvoice;

import java.time.LocalDate;

public interface MealCostRepository {
    MealInvoice get(LocalDate date);
}
