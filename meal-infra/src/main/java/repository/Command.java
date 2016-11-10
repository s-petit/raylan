package repository;

import java.util.List;

/**
 * Created by spetit on 11/08/2016.
 */
public abstract class Command<DOMAIN, EVENT extends Event> {

    // decide :: Command -> State -> [Event]

    // apply :: State -> Event -> State

    public abstract List<EVENT> decide(DOMAIN domain);
    public abstract EVENT toEvent();
}
