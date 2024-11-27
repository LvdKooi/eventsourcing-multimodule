package nl.cjib.eventsourcing.infra.mapper;


import nl.cjib.eventsourcing.core.domain.event.BetalingsverplichtingIngetrokken;
import nl.cjib.eventsourcing.core.domain.event.BetalingsverplichtingOpgelegd;
import nl.cjib.eventsourcing.core.domain.event.Event;
import nl.cjib.eventsourcing.core.domain.event.FinancieleVerplichtingOpgelegd;
import nl.cjib.eventsourcing.infra.entity.BetalingsverplichtingIngetrokkenEntity;
import nl.cjib.eventsourcing.infra.entity.BetalingsverplichtingOpgelegdEntity;
import nl.cjib.eventsourcing.infra.entity.EventEntity;
import nl.cjib.eventsourcing.infra.entity.FinancieleVerplichtingOpgelegdEntity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface EventMapper {


    BetalingsverplichtingIngetrokken map(BetalingsverplichtingIngetrokkenEntity model);

    BetalingsverplichtingOpgelegd map(BetalingsverplichtingOpgelegdEntity model);

    FinancieleVerplichtingOpgelegd map(FinancieleVerplichtingOpgelegdEntity model);

    default Event map(EventEntity event) {
        return switch (event) {
            case BetalingsverplichtingIngetrokkenEntity bvi -> map(bvi);
            case BetalingsverplichtingOpgelegdEntity bvo -> map(bvo);
            case FinancieleVerplichtingOpgelegdEntity fvo -> map(fvo);
            default -> null;
        };
    }
}
