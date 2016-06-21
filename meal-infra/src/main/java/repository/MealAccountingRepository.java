package repository;

import meal.MealAccounting;
import meal.valueobject.MealInvoice;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

public class MealAccountingRepository implements MealAccounting {

    @Override
    public MealInvoice get(LocalDate date) {
        return new MealInvoice(15.5, LocalDate.of(2016, Month.FEBRUARY, 03), "Chinois");
    }

    @Override
    public List<MealInvoice> get(YearMonth yearMonth) {
        MealInvoice februaryInvoice1 = new MealInvoice(15.5, LocalDate.of(2016, Month.FEBRUARY, 1), "Japonais"); // 15.5 -> 2.5
        MealInvoice februaryInvoice2 = new MealInvoice(20.5, LocalDate.of(2016, Month.FEBRUARY, 2), "Bouchon");
        return Arrays.asList(februaryInvoice1, februaryInvoice2);
    }

    @Override
    public void save(MealInvoice mealInvoice) {
        return;
    }
}
