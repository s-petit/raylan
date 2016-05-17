package meal.valueobject;

import annotation.ValueObject;

import java.time.Year;

/**
 * Le barème annuel déductible des frais de repas
 * @link http://www.leparticulier.fr/jcms/p1_1601766/bic-et-bnc-limites-de-deduction-des-frais-de-repas-pour-2016
 */
@ValueObject
public final class MealYearlyScale {

    public final Integer min;
    public final Integer max;
    public final Year year;

    public MealYearlyScale(Integer min, Integer max, Year year) {
        this.min = min;
        this.max = max;
        this.year = year;
    }
}
