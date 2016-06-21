package meal.valueobject;

import annotation.ValueObject;

import java.time.LocalDate;

/**
 * Représente la facture du repas
 */
@ValueObject
public final class MealInvoice {

    //TODO SPE : contrainte d'unicité sur la date ???
    // TODO : qui se charge de la validation non null

    public final Double price;
    public final LocalDate date;
    public final String label;

    public MealInvoice(Double price, LocalDate date, String label) {
        if (price <= 0) {
            throw new IllegalArgumentException("A Meal Invoice price must be positive");
        }
        this.price = price;
        this.date = date;
        this.label = label;
    }
}
