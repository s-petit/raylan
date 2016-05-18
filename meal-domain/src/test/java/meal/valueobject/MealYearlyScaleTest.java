package meal.valueobject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by spetit on 18/05/2016.
 */
public class MealYearlyScaleTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_not_handle_years_before_2016() {
        new MealYearlyScale(1.0, 2.0, 2015);
    }

    @Test(expected = IllegalArgumentException.class)
    public void min_scale_should_be_positive() {
        new MealYearlyScale(-10.0, 2.0, 2016);
    }

    @Test(expected = IllegalArgumentException.class)
    public void max_scale_should_be_positive() {
        new MealYearlyScale(1.0, -2.0, 2016);
    }

    @Test(expected = IllegalArgumentException.class)
    public void max_scale_should_be_greater_than_min_scale() {
        new MealYearlyScale(10.0, 2.0, 2016);
    }

}