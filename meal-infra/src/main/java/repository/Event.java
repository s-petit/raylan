package repository;

import java.util.List;

public abstract class Event<DOMAIN, COMMAND extends Command> {

    public abstract DOMAIN apply(DOMAIN domain);

    public abstract List<? extends Event> decide(DOMAIN domain, COMMAND command);

    public abstract EventRecord toRecord(DOMAIN domain);

    public abstract DOMAIN toDomain();

    public abstract Event fromCommand(COMMAND command);

    public Event(COMMAND command) {
    }

    public Event() {
    }
}
