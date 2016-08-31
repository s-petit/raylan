package configuration;

public class MealYearlyScaleRequest {

    public final int year;
    public final Double min;
    public final Double max;

    public MealYearlyScaleRequest(int year, Double min, Double max) {
        this.year = year;
        this.min = min;
        this.max = max;
    }
}
