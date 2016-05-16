package meal;

import annotation.ValueObject;

import java.time.LocalDate;

/**
 * Created by spetit on 17/05/2016.
 */
@ValueObject
public final class MealExpense {

    public final Short amount;
    public final LocalDate date;

    public MealExpense(Short amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }
}
