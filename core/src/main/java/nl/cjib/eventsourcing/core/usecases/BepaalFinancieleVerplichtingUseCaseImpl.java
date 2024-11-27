package nl.cjib.eventsourcing.core.usecases;

import lombok.RequiredArgsConstructor;
import nl.cjib.eventsourcing.core.command.BepaalFinancieleVerplichtingCommand;
import nl.cjib.eventsourcing.core.domain.aggregator.FinancieleVerplichtingAggregator;
import nl.cjib.eventsourcing.core.domain.aggregator.aggregate.FinancieleVerplichting;
import nl.cjib.eventsourcing.core.domain.event.Event;
import nl.cjib.eventsourcing.core.domain.dao.EventDAO;
import nl.cjib.eventsourcing.core.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class BepaalFinancieleVerplichtingUseCaseImpl implements BepaalFinancieleVerplichtingUseCase {

    private final EventDAO eventDAO;


    public FinancieleVerplichting handle(BepaalFinancieleVerplichtingCommand command) {
        return Optional.ofNullable(command)
                .map(this::getEvents)
                .filter(notEmpty())
                .map(events -> FinancieleVerplichtingAggregator.aggregateEvents(events, command.peildatum()))
                .orElseThrow(NotFoundException::new);
    }

    private Set<Event> getEvents(BepaalFinancieleVerplichtingCommand command) {
        return eventDAO.getEventsForVerplichtingnummer(command.verplichtingnummer());
    }

    private static Predicate<Set<Event>> notEmpty() {
        return events -> !events.isEmpty();
    }
}
