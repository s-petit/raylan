package repository;

import meal.valueobject.MealYearlyScale;

import java.util.Arrays;
import java.util.List;

public final class MealYearlyScaleCommand extends Command<MealYearlyScale, MealYearlyScaleUpdated> {

    public final int year;
    public final Double min;
    public final Double max;

    public MealYearlyScaleCommand(int year, Double min, Double max) {
        this.year = year;
        this.min = min;
        this.max = max;
    }

    @Override
    public List<MealYearlyScaleUpdated> decide(MealYearlyScale mealYearlyScale) {
        // no need of domain object right now
        MealYearlyScaleUpdated event = toEvent();
        return Arrays.asList(event);
    }

    public MealYearlyScaleUpdated toEvent() {
        return new MealYearlyScaleUpdated(min, max, year);
    }

}
