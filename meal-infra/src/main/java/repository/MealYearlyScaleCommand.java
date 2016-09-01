package repository;

import meal.valueobject.MealYearlyScale;

import java.util.Arrays;
import java.util.List;

public final class MealYearlyScaleCommand extends Command<MealYearlyScale> {

    public final int year;
    public final Double min;
    public final Double max;

    public MealYearlyScaleCommand(int year, Double min, Double max) {
        this.year = year;
        this.min = min;
        this.max = max;
    }

    @Override
    public List<Event> decide(MealYearlyScale mealYearlyScale) {
        // no need of domain object right now
        MealYearlyScaleUpdated event = new MealYearlyScaleUpdated(this);
        return Arrays.asList(event);
    }

}
