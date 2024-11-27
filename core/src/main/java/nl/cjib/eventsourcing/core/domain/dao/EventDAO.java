package nl.cjib.eventsourcing.core.domain.dao;


import nl.cjib.eventsourcing.core.domain.event.Event;

import java.util.Set;

public interface EventDAO {

    Set<Event> getEventsForVerplichtingnummer(String verplichtingnummer);

}
