package configuration;

import com.codahale.metrics.annotation.Timed;
import meal.valueobject.MealInvoice;
import repository.MealAccountingRepository;
import repository.MealYearlyScaleCommand;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/meals")
@Produces(MediaType.APPLICATION_JSON)
public class MealResource {


    @GET
    @Timed
    @Path("/all")
    public List<MealInvoiceDTO> mealInvoices() {
        List<MealInvoice> invoices = new MealAccountingRepository().get(YearMonth.of(2016, Month.FEBRUARY));
        return invoices.stream().map(mealInvoice -> new MealInvoiceDTO(mealInvoice)).collect(Collectors.toList());
    }

    @GET
    @Timed
    @Path("/one")
    public MealInvoiceDTO firstMealInvoices() {
        List<MealInvoice> invoices = new MealAccountingRepository().get(YearMonth.of(2016, Month.FEBRUARY));
        return invoices.stream().map(mealInvoice -> new MealInvoiceDTO(mealInvoice)).findFirst().orElse(new MealInvoiceDTO(new MealInvoice(new Double(99), LocalDate.now(), "OSEF")));
    }

    @POST
    @Timed
    @Path("/scale")
    public void addMealYearlyScale(MealYearlyScaleRequest request) {
        MealYearlyScaleCommand command = new MealYearlyScaleCommand(request.year, request.min, request.max);
        new MYSR
    }
}
