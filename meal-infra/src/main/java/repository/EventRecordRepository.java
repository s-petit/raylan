package repository;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.jooq.util.maven.example.tables.EventStore;

import java.time.ZonedDateTime;
import java.util.Collections;

// SPECIFIC TO DATABASE AND FMWK
// ADD JOOQ STUFF
public class EventRecordRepository<DOMAIN, EVENT extends Event> {

    public EventRecord getRecord() {
        Result<Record> result =  DSL.using(RaylanConnection.get()).select().from(EventStore.EVENT_STORE).fetch();
        return new EventRecord(1L, "agreggart", "MealYearlyScale", 1L, 1L, 1L, ZonedDateTime.now(), Collections.emptyList());
    }
/*
    public DOMAIN get(EventRecord record) {

        return record.getEvents().
        return new MealYearlyScale(MIN_SCALE_2016, MAX_SCALE_2016, year);
    }*/

    public void save(EventRecord eventRecord) {

    }

}
