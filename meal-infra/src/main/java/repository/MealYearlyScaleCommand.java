package repository;

public final class MealYearlyScaleCommand extends Command {

    public final int year;
    public final Double min;
    public final Double max;

    public MealYearlyScaleCommand(int year, Double min, Double max) {
        this.year = year;
        this.min = min;
        this.max = max;
    }

}
