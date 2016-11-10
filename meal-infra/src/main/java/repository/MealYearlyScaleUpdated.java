package repository;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import meal.valueobject.MealYearlyScale;

public class MealYearlyScaleUpdated extends Event<MealYearlyScale> {

    public final Double min;
    public final Double max;
    public final int year;

    @JsonCreator
    public MealYearlyScaleUpdated(@JsonProperty("min") Double min, @JsonProperty("max") Double max, @JsonProperty("year") int year) {
        this.min = min;
        this.max = max;
        this.year = year;
    }

    @Override
    public MealYearlyScale toDomain() {
        return new MealYearlyScale(min, max, year);
    }

    @Override
    public EventRecord toRecord(MealYearlyScale mealYearlyScale) {
        return null;
    }

    @Override
    public MealYearlyScale apply(MealYearlyScale mealYearlyScale) {
        return this.toDomain();
    }

/*
    @Override
    public MealYearlyScaleUpdated fromCommand(MealYearlyScaleCommand command) {
        return new MealYearlyScaleUpdated(command.min, command.max, command.year);
    }
*/

}
