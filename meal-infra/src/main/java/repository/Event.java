package repository;

public abstract class Event<DOMAIN> {

    public abstract DOMAIN apply(DOMAIN domain);

    public abstract EventRecord toRecord(DOMAIN domain);

    public abstract DOMAIN toDomain();

    //public abstract Event fromCommand(COMMAND command);

}
