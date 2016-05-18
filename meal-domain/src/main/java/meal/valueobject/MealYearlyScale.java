package meal.valueobject;

import annotation.ValueObject;

import java.time.Year;

/**
 * Le barème annuel déductible des frais de repas
 * @link http://www.leparticulier.fr/jcms/p1_1601766/bic-et-bnc-limites-de-deduction-des-frais-de-repas-pour-2016
 */
@ValueObject
public final class MealYearlyScale {

    public final Double min;
    public final Double max;
    public final Year year;

    public MealYearlyScale(Double min, Double max, int year) {
        this.min = min;
        this.max = max;
        this.year = Year.of(year);
    }
}
