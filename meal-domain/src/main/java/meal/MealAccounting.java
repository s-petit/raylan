package meal;

import meal.valueobject.MealInvoice;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface MealAccounting {
    MealInvoice get(LocalDate date);
    List<MealInvoice> get(YearMonth yearMonth);
}
