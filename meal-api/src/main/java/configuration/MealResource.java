package configuration;

import com.codahale.metrics.annotation.Timed;
import meal.valueobject.MealInvoice;
import repository.MealAccountingRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

@Path("/meal")
@Produces(MediaType.APPLICATION_JSON)
public class MealResource {

    @GET
    @Timed
    public List<MealInvoice> mealInvoices() {
        return new MealAccountingRepository().get(YearMonth.of(2016, Month.FEBRUARY));
    }
}
