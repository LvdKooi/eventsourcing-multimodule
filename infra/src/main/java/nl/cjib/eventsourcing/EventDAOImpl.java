package nl.cjib.eventsourcing;

import lombok.RequiredArgsConstructor;
import nl.cjib.eventsourcing.entity.EventEntity;
import nl.cjib.eventsourcing.repository.EventRepository;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class EventDAOImpl implements EventDAO {

    private final EventRepository eventRepository;


    @Override
    public Set<EventEntity> getEventsForVerplichtingnummer(String verplichtingnummer) {
        return eventRepository
                .findAllByVerplichtingsnummer(verplichtingnummer);
    }
}
