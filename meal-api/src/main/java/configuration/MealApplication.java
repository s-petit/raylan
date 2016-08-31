package configuration;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import repository.MealAllowanceRuleRepository;

public class MealApplication extends Application<MealConfiguration> {

    public static void main(String[] args) throws Exception {
        new MealApplication().run(args);
    }
    //TODO SPE : a quoi sert un adapteur ??
    // TODO SPE : pourquoi le shaded maven plugin et est ce une bonne pratique
    @Override
    public void run(MealConfiguration mealConfiguration, Environment environment) throws Exception {
        final MealResource resource = new MealResource(new MealAllowanceRuleRepository());
        environment.jersey().register(resource);
    }
}
