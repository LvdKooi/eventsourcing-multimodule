package nl.cjib.eventsourcing.infra.dao;

import lombok.RequiredArgsConstructor;
import nl.cjib.eventsourcing.core.domain.dao.EventDAO;
import nl.cjib.eventsourcing.core.domain.event.Event;
import nl.cjib.eventsourcing.infra.mapper.EventMapper;
import nl.cjib.eventsourcing.infra.repository.EventRepository;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class EventDAOImpl implements EventDAO {

    private final EventRepository eventRepository;
    private final EventMapper mapper;


    @Override
    public Set<Event> getEventsForVerplichtingnummer(String verplichtingnummer) {
        return eventRepository
                .findAllByVerplichtingsnummer(verplichtingnummer)
                .stream()
                .map(mapper::map)
                .collect(Collectors.toSet());
    }
}
