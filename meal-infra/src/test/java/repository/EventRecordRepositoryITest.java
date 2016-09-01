package repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class EventRecordRepositoryITest extends AbstractDatabaseITest {

    @Autowired
    private EventRecordRepository repository;

    @Test
    public void getRecord() {
        EventRecord record = new EventRecord(UUID.randomUUID(), "agreggart", "meal", 1L, 1L, 1L, ZonedDateTime.now(), Collections.emptyList());

        repository.save(record);

        String aggregateId = repository.getAggregateId();

        assertThat(aggregateId).isEqualTo("agreggart");
    }

    //TODO SPE reflechir a une maniere de typer les events quand on les recup de la base
    @Test
    public void save() {
        EventRecord record = new EventRecord(UUID.randomUUID(), "2014", "meal", 1L, 1L, 1L, ZonedDateTime.now(), Collections.emptyList());
        repository.save(record);
        repository.saveEvents("2014", Arrays.asList(new MealYearlyScaleUpdated(5.00, 15.00, 2014), new MealYearlyScaleUpdated(6.00, 16.00, 2014)));

        List<Event> eventsByAggregateId = repository.getEventsByAggregateId("2014");

        assertThat(eventsByAggregateId).hasSize(2);
        assertThat(eventsByAggregateId.get(0)).isInstanceOf(MealYearlyScaleUpdated.class);
        assertThat(eventsByAggregateId).extracting("min").containsExactly(5.00, 6.00);
    }
}