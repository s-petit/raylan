package repository;

public abstract class Event<DOMAIN, COMMAND extends Command> {

    public abstract DOMAIN apply(DOMAIN domain);

    public abstract EventRecord toRecord(DOMAIN domain);

    public abstract DOMAIN toDomain();
}
