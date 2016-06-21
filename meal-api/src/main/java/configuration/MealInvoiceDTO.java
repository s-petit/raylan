package configuration;

import meal.valueobject.MealInvoice;

import java.time.format.DateTimeFormatter;

public class MealInvoiceDTO {

    private String date;
    private Double price;
    private String label;

    public MealInvoiceDTO(MealInvoice mealInvoice) {
        this.date = mealInvoice.date.format(DateTimeFormatter.ISO_DATE);
        this.price = mealInvoice.price;
        this.label = mealInvoice.label;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
