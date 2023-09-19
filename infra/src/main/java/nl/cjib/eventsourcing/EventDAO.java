package nl.cjib.eventsourcing;


import nl.cjib.eventsourcing.entity.EventEntity;

import java.util.Set;

public interface EventDAO {

    Set<EventEntity> getEventsForVerplichtingnummer(String verplichtingnummer);

}
