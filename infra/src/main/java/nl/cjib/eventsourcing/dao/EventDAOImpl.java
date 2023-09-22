package nl.cjib.eventsourcing.dao;

import lombok.RequiredArgsConstructor;
import nl.cjib.eventsourcing.domain.dao.EventDAO;
import nl.cjib.eventsourcing.domain.event.Event;
import nl.cjib.eventsourcing.mapper.EventMapper;
import nl.cjib.eventsourcing.repository.EventRepository;
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
