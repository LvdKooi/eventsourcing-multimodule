package nl.cjib.eventsourcing.domain.dao;


import nl.cjib.eventsourcing.domain.event.Event;

import java.util.Set;

public interface EventDAO {

    Set<Event> getEventsForVerplichtingnummer(String verplichtingnummer);

}
