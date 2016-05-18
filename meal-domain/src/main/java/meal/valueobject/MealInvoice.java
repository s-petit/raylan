package meal.valueobject;

import annotation.ValueObject;

import java.time.LocalDate;

/**
 * Représente la facture du repas
 */
@ValueObject
public final class MealInvoice {

    //TODO SPE : contrainte d'unicité sur la date ???

    public final Double amount;
    public final LocalDate date;

    public MealInvoice(Double amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("A Meal Invoice price must be positive");
        }
        this.amount = amount;
        this.date = date;
    }
}
