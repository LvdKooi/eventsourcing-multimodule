package nl.cjib.eventsourcing.mapper;


import nl.cjib.eventsourcing.domain.event.BetalingsverplichtingIngetrokken;
import nl.cjib.eventsourcing.domain.event.BetalingsverplichtingOpgelegd;
import nl.cjib.eventsourcing.domain.event.Event;
import nl.cjib.eventsourcing.domain.event.FinancieleVerplichtingOpgelegd;
import nl.cjib.eventsourcing.entity.BetalingsverplichtingIngetrokkenEntity;
import nl.cjib.eventsourcing.entity.BetalingsverplichtingOpgelegdEntity;
import nl.cjib.eventsourcing.entity.EventEntity;
import nl.cjib.eventsourcing.entity.FinancieleVerplichtingOpgelegdEntity;

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
