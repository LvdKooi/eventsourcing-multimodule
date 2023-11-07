package nl.cjib.eventsourcing.mapper;


import nl.cjib.eventsourcing.domain.aggregator.aggregate.Betalingsverplichting;
import nl.cjib.eventsourcing.domain.aggregator.aggregate.FinancieleVerplichting;
import nl.cjib.eventsourcing.domain.event.BetalingsverplichtingIngetrokken;
import nl.cjib.eventsourcing.domain.event.BetalingsverplichtingOpgelegd;
import nl.cjib.eventsourcing.domain.event.Event;
import nl.cjib.eventsourcing.domain.event.FinancieleVerplichtingOpgelegd;
import nl.cjib.eventsourcing.dto.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@org.mapstruct.Mapper(componentModel = "spring")
public interface DtoMapper {

    BetalingsverplichtingDTO map(Betalingsverplichting model);

    @AfterMapping
    default void sortGebeurtenissenAndVerplichtingen(@MappingTarget FinancieleVerplichtingDTO financieleVerplichting) {

        var sortedGebeurtenissen = sort(financieleVerplichting.getGebeurtenissen(), Comparator.comparing(EventDTO::getEventId).thenComparing(EventDTO::getEventDate));
        var sorterVerplichtingen = sort(financieleVerplichting.getBetalingsverplichtingen(), Comparator.comparing(BetalingsverplichtingDTO::getVervaldatum));

        financieleVerplichting.setGebeurtenissen(sortedGebeurtenissen);
        financieleVerplichting.setBetalingsverplichtingen(sorterVerplichtingen);
    }

    private static <T> Set<T> sort(Set<T> baseSet, Comparator<T> comparator) {
        return baseSet.stream()
                .sorted(comparator)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Mapping(target = "eventType", expression = "java(model.eventType())")
    BetalingsverplichtingIngetrokkenDTO map(BetalingsverplichtingIngetrokken model);

    @Mapping(target = "eventType", expression = "java(model.eventType())")
    BetalingsverplichtingOpgelegdDTO map(BetalingsverplichtingOpgelegd model);

    FinancieleVerplichtingDTO map(FinancieleVerplichting financieleVerplichting);

    @Mapping(target = "eventType", expression = "java(model.eventType())")
    FinancieleVerplichtingOpgelegdDTO map(FinancieleVerplichtingOpgelegd model);

    default EventDTO map(Event event) {
        return switch (event) {
            case BetalingsverplichtingIngetrokken bvi -> map(bvi);
            case BetalingsverplichtingOpgelegd bvo -> map(bvo);
            case FinancieleVerplichtingOpgelegd fvo -> map(fvo);
            default -> null;
        };
    }

}
