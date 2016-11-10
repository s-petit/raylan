package repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import static org.jooq.util.maven.tables.EventStore.EVENT_STORE;

// SPECIFIC TO DATABASE AND FMWK
// ADD JOOQ STUFF
// creer des methodes moins generiques, on a rarement besoin de tout le record a la fois, juste du payload
@Repository
public class EventRecordRepository {
//<DOMAIN, EVENT extends Event>
    @Autowired
    private DSLContext dsl;
    @Autowired
    private ObjectMapper objectMapper;

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

    public EventRecord getByAggregateId(int year) throws IOException {
        Record r = dsl.select().from(EVENT_STORE).where(EVENT_STORE.AGGREGATE_ID.eq(year+"")).fetchOne();
        return new EventRecord(r.get(EVENT_STORE.UUID),
                r.get(EVENT_STORE.AGGREGATE_ID),
                r.get(EVENT_STORE.AGGREGATE_TYPE),
                r.get(EVENT_STORE.USER_ID),
                r.get(EVENT_STORE.VERSION),
                r.get(EVENT_STORE.PROCESS_ID),
                ZonedDateTime.ofInstant(r.get(EVENT_STORE.DATE).toInstant(), ZoneOffset.UTC),
                objectMapper.readValue(r.get(EVENT_STORE.PAYLOAD), List.class)
        );
    }

    public List<Event> getEventsByAggregateId(String aggregateId) {
        Record r = dsl.select().from(EVENT_STORE).where(EVENT_STORE.AGGREGATE_ID.eq(aggregateId)).fetchOne();
        try {
            return objectMapper.readValue(r.get(EVENT_STORE.PAYLOAD), new TypeReference<List<MealYearlyScaleUpdated>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO SPE : meilleure gestion de cette exception
        return null;
    }

    // TODO SPE type l'aggregate id
    // TODO SPE faire une classe dediee pour la serialization / deserialization
    public void saveEvents(String aggregateId, List<Event> events) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(events);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        dsl.update(EVENT_STORE).set(EVENT_STORE.PAYLOAD, json).where(EVENT_STORE.AGGREGATE_ID.eq(aggregateId)).execute();
    }
}
