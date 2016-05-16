package meal;

import annotation.ValueObject;

import java.time.Year;
import java.util.Date;

/**
 * Created by spetit on 17/05/2016.
 */
@ValueObject
public final class MealAllowance {

    public final Short min;
    public final Short max;
    public final Year year;

    public MealAllowance(Short min, Short max, Year year) {
        this.min = min;
        this.max = max;
        this.year = year;
    }
}
