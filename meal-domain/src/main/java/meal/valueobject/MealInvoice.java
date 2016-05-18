package meal.valueobject;

import annotation.ValueObject;

import java.time.LocalDate;

/**
 * Représente la facture du repas
 */
@ValueObject
public final class MealInvoice {

    //TODO SPE : contrainte d'unicité sur la date ???

    public final Double price;
    public final LocalDate date;

    public MealInvoice(Double price, LocalDate date) {
        if (price <= 0) {
            throw new IllegalArgumentException("A Meal Invoice price must be positive");
        }
        this.price = price;
        this.date = date;
    }
}
