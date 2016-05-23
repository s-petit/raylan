package configuration;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MealApplication extends Application<MealConfiguration> {

    public static void main(String[] args) throws Exception {
        new MealApplication().run(args);
    }

    @Override
    public void run(MealConfiguration mealConfiguration, Environment environment) throws Exception {
        final MealResource resource = new MealResource();
        environment.jersey().register(resource);
    }
}
