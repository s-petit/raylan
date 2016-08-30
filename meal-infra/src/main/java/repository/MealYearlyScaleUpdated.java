package repository;

import meal.valueobject.MealYearlyScale;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class MealYearlyScaleUpdated extends Event<MealYearlyScale, MealYearlyScaleCommand> {

    public final Double min;
    public final Double max;
    public final int year;

    public MealYearlyScaleUpdated(Double min, Double max, int year) {
        this.min = min;
        this.max = max;
        this.year = year;
    }

    @Override
    public MealYearlyScale toDomain() {
        return new MealYearlyScale(min, max, year);
    }

    @Override
    public MealYearlyScaleUpdated fromCommand(MealYearlyScaleCommand command) {
        return new MealYearlyScaleUpdated(command.min, command.max, command.year);
    }

    @Override
    public MealYearlyScale apply(MealYearlyScale mealYearlyScale) {
        return this.toDomain();
    }

    @Override
    public List<MealYearlyScaleUpdated> decide(MealYearlyScale mealYearlyScale, MealYearlyScaleCommand command) {
        MealYearlyScaleUpdated event = fromCommand(command);
        return Arrays.asList(event);
    }

    @Override
    public EventRecord toRecord(MealYearlyScale mealYearlyScale) {
        return null;
    }

/*    @Override
    public void record(MealYearlyScale mealYearlyScale, List<MealYearlyScaleUpdated> event) {
        EventRecord record = new EventRecord(666L, "aggId", "mealScale", 1L, 1L, 1L, ZonedDateTime.now(), event);
    }*/

    //decide :: Command -> State -> [Event]

    //apply :: State -> Event -> State

    //event sourcing sqns cqrs
    // j'appelle l'api
    // je cree une commande a partir de l'api
    // j'appelle le repo a partir de la commande
    // le repo ramene l entite domaine a partir de la commande
    // on cree les evenements associes a partir de la commande et de l'etat courant (decide)
    // on cree ou on ramene l'agregat a partir de l'id de l'entite
    // on ajoute les evenements a l'agregat
    // on sauvegarde l agregat avec les nouveaux evenements

    // event sourcing sans cqrs
    // j appelle l'api
    // je cree une query a partir de l'api

    // je veux une entite specifique
    // j'appelle le repo avec la qeury
    // le repos ramene l'agregat avec l'id
    // je construit l'entite ou la projection en rejouant tous les evenements (apply)
    // je cree un DTO pour afficher

    // je veux une liste d'entites filtrees
    // j'appelle le repo avec la qeury
    // le repos ramene les agregats avec le type des entites
    // je construit les entites en rejouant tous les evenements pour chaque (apply)
    // je filtre en java avec la query
    // je convertis en DTO

    // pb de performance
    // objets et aggregats mal adaptes aux besoins de la requete/query
    // il faut tout reconstruire a chaque requete
    // besoin de dto pour afficher
    // operations lourdes en synchrone



    // event sourcing avec cqrs
    // j appelle l'api
    // je cree une query a partir de l'api
    // toutes mes tables sont des projections cree specialement pour les besoins d'affichage
    // j appelle le repo avec la commande
    // je retourne le resultat


    //TODO handlers events bus pour faire ca en async



}
