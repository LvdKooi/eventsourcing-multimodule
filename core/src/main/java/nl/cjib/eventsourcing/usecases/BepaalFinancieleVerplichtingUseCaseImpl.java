package nl.cjib.eventsourcing.usecases;

import lombok.RequiredArgsConstructor;
import nl.cjib.eventsourcing.domain.aggregator.aggregate.FinancieleVerplichting;
import nl.cjib.eventsourcing.domain.event.Event;
import nl.cjib.eventsourcing.domain.mapper.EventMapper;
import nl.cjib.eventsourcing.exception.NotFoundException;
import nl.cjib.eventsourcing.dao.EventDAO;
import nl.cjib.eventsourcing.command.BepaalFinancieleVerplichtingCommand;
import nl.cjib.eventsourcing.domain.aggregator.FinancieleVerplichtingAggregator;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BepaalFinancieleVerplichtingUseCaseImpl implements BepaalFinancieleVerplichtingUseCase {

    private final EventDAO eventDAO;
    private final EventMapper mapper;

    public FinancieleVerplichting handle(BepaalFinancieleVerplichtingCommand command) {
        return Optional.ofNullable(command)
                .map(this::getEvents)
                .filter(notEmpty())
                .map(events -> FinancieleVerplichtingAggregator.aggregateEvents(events, command.peildatum()))
                .orElseThrow(NotFoundException::new);
    }

    private Set<Event> getEvents(BepaalFinancieleVerplichtingCommand command) {
        return eventDAO.getEventsForVerplichtingnummer(command.verplichtingnummer())
                .stream()
                .map(mapper::map)
                .collect(Collectors.toSet());
    }

    private static Predicate<Set<Event>> notEmpty() {
        return events -> !events.isEmpty();
    }
}
