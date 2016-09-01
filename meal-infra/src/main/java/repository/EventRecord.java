package repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

// <T> est soit un IEvenement, soit une IEntite
public class EventRecord {

    private UUID uuid; //unique ID
    private String aggregateId; // could be long si on utilise le type en combinaison
    private String aggregateType; // could be an enum
    private Long userId; // a mettre a ce niveau ou bien au niveau de chaque evt -> ou alors le renommer en lastUpdatedUserId
    private Long version;
    private Long processId;
    private ZonedDateTime date;
    private List<Event> events; // convert to json ce champ devrait etre un string non ?
    //private T aggregate; // a quoi sert ce champ ?


    public EventRecord(UUID uuid, String aggregateId, String aggregateType, Long userId, Long version, Long processId, ZonedDateTime date, List<Event> events) {
        this.uuid = uuid;
        this.aggregateId = aggregateId;
        this.aggregateType = aggregateType;
        this.userId = userId;
        this.version = version;
        this.processId = processId;
        this.date = date;
        this.events = events;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /*
    public string SessionId { get; set; } // Can be set in emitter.
    public string RequestId { get; set; } // Can be set in emitter.
    public DateTime CreatedDate { get; set; } // Can be set in emitter.
    public string EventName { get; set; } // Extract from class or interface name.
    public string EventVersion { get; set; } // Extract from class name
    public T EventModel { get; set; } // Can be set in emitter.*/
}
