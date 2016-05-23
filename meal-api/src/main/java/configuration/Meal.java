package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Meal {

    private LocalDate date;
    private BigDecimal price;


    public Meal(LocalDate date, BigDecimal price) {
        this.date = date;
        this.price = price;
    }

    @JsonProperty
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @JsonProperty
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
