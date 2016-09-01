package repository;

import java.util.List;

/**
 * Created by spetit on 11/08/2016.
 */
public abstract class Command<DOMAIN> {

    // decide :: Command -> State -> [Event]

    // apply :: State -> Event -> State

    public abstract List<Event> decide(DOMAIN domain);
}
