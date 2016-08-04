package repository;

import meal.valueobject.MealYearlyScale;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class MealYearlyScaleUpdated extends Event<MealYearlyScale, MealYearlyScaleCommand> {

    public final Double min;
    public final Double max;
    public final int year;

    public MealYearlyScaleUpdated(Double min, Double max, int year) {
        this.min = min;
        this.max = max;
        this.year = year;
    }

    @Override
    public MealYearlyScale toDomain() {
        return new MealYearlyScale(min, max, year);
    }

    @Override
    public MealYearlyScaleUpdated fromCommand(MealYearlyScaleCommand command) {
        return new MealYearlyScaleUpdated(command.min, command.max, command.year);
    }

    @Override
    public MealYearlyScale apply(MealYearlyScale mealYearlyScale) {
        return this.toDomain();
    }

    @Override
    public List<MealYearlyScaleUpdated> decide(MealYearlyScale mealYearlyScale, MealYearlyScaleCommand command) {
        MealYearlyScaleUpdated event = fromCommand(command);
        return Arrays.asList(event);
    }

    @Override
    public EventRecord toRecord(MealYearlyScale mealYearlyScale) {
        return null;
    }

/*    @Override
    public void record(MealYearlyScale mealYearlyScale, List<MealYearlyScaleUpdated> event) {
        EventRecord record = new EventRecord(666L, "aggId", "mealScale", 1L, 1L, 1L, ZonedDateTime.now(), event);
    }*/

}
