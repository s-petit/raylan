package repository;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.UUID;

import static org.jooq.util.maven.tables.EventStore.EVENT_STORE;

// SPECIFIC TO DATABASE AND FMWK
// ADD JOOQ STUFF
// creer des methodes moins generiques, on a rarement besoin de tout le record a la fois, juste du payload
@Repository
public class EventRecordRepository {
//<DOMAIN, EVENT extends Event>
    @Autowired
    private DSLContext dsl;

    public String getAggregateId() {
        Record r = dsl.select().from(EVENT_STORE).limit(1).fetchOne();
        return r.get(EVENT_STORE.AGGREGATE_ID);
    }
/*
    public DOMAIN get(EventRecord record) {

        return record.getEvents().
        return new MealYearlyScale(MIN_SCALE_2016, MAX_SCALE_2016, year);
    }*/

    public void save(EventRecord eventRecord) {
        dsl.insertInto(EVENT_STORE, EVENT_STORE.UUID, EVENT_STORE.AGGREGATE_ID, EVENT_STORE.AGGREGATE_TYPE, EVENT_STORE.PAYLOAD, EVENT_STORE.USER_ID, EVENT_STORE.VERSION, EVENT_STORE.PROCESS_ID, EVENT_STORE.DATE)
                .values(eventRecord.getUuid(), eventRecord.getAggregateId(), eventRecord.getAggregateType(), eventRecord.getEvents().toString(), eventRecord.getUserId(), eventRecord.getVersion(), eventRecord.getProcessId(), Timestamp.from(eventRecord.getDate().toInstant()))
                .execute();
    }

    public void delete(String aggregateId, String aggregateType) {
        dsl.deleteFrom(EVENT_STORE)
                .where(EVENT_STORE.AGGREGATE_ID.equal(aggregateId))
                .and(EVENT_STORE.AGGREGATE_TYPE.equal(aggregateType))
                .execute();

    }

    public EventRecord getByAggregateId(UUID uuid) {
        Record r = dsl.select().from(EVENT_STORE).where(EVENT_STORE.UUID.eq(uuid)).fetchOne();
        return new EventRecord(r.get(EVENT_STORE.UUID),
                r.get(EVENT_STORE.AGGREGATE_ID),
                r.get(EVENT_STORE.AGGREGATE_TYPE),
                r.get(EVENT_STORE.USER_ID),
                r.get(EVENT_STORE.VERSION),
                r.get(EVENT_STORE.PROCESS_ID),
                ZonedDateTime.ofInstant(r.get(EVENT_STORE.DATE).toInstant(), ZoneOffset.UTC),
                Arrays.asList(new MealYearlyScaleUpdated());

        //TODO clean parsing of payload to string or event
                r.get(EVENT_STORE.AGGREGATE_ID);
    }
}
