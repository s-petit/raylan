package meal.valueobject;

import annotation.ValueObject;

import java.time.Year;

/**
 * Le barème annuel déductible des frais de repas
 * @link http://www.leparticulier.fr/jcms/p1_1601766/bic-et-bnc-limites-de-deduction-des-frais-de-repas-pour-2016
 */
@ValueObject
public final class MealYearlyScale {

    public static final int YEAR_2016 = 2016;
    public final Double min;
    public final Double max;
    public final Year year;

    public MealYearlyScale(Double min, Double max, int year) {
        validate(min, max, year);

        this.min = min;
        this.max = max;
        this.year = Year.of(year);
    }

    private void validate(Double min, Double max, int year) {
        if (min < 0) {
            throw new IllegalArgumentException("A minimal scale price must be positive");
        }
        if (max < 0) {
            throw new IllegalArgumentException("A maximum scale price must be positive");
        }
        if (max < min) {
            throw new IllegalArgumentException("A maximum scale price must be greater than minimum scale");
        }
        if (year < YEAR_2016) {
            throw new IllegalArgumentException("This app was started in 2016, no need to handle years in the past.");
        }
    }
}
