package repository;

import meal.AllowanceRule;
import meal.valueobject.MealYearlyScale;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Meal Allowance : frais de repas
 * Repositories sur les regles métier de frais de repas
 */
public class MealAllowanceRuleRepository implements AllowanceRule {

    @Autowired
    private EventRecordRepository repository;

    //TODO SPE comment faire de la DI sans spring ? singleton ?
    private static final double MIN_SCALE_2016 = 4.7;
    private static final double MAX_SCALE_2016 = 18.3;

    @Override
    public MealYearlyScale get(int year) {
        return new MealYearlyScale(MIN_SCALE_2016, MAX_SCALE_2016, year);
    }

    //TODO SPE : peut etre une seule methode qui recup les events les add et les save
    public void save(MealYearlyScaleCommand command) {
        MealYearlyScale scale = get(command.year);
        List<MealYearlyScaleUpdated> updated = command.decide(scale);
        List<Event> events = repository.getEventsByAggregateId(command.year+"");
        events.addAll(updated);

    }

    // soit une uber table pour tous les aggregate id = aggr id + type
    // soit une table par bouded context
}
