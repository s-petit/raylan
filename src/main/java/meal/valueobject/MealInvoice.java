package meal.valueobject;

import annotation.ValueObject;

import java.time.LocalDate;

/**
 * Représente la facture du repas
 */
@ValueObject
public final class MealInvoice {

    public final Integer amount;
    public final LocalDate date;

    public MealInvoice(Integer amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("A Meal Invoice price must be positive");
        }
        this.amount = amount;
        this.date = date;
    }
}
