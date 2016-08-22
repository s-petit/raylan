package repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
import java.util.Collections;
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
}