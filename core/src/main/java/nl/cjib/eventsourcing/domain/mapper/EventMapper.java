package nl.cjib.eventsourcing.domain.mapper;


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
        if (event instanceof BetalingsverplichtingIngetrokkenEntity bvi) {
            return map(bvi);
        }

        if (event instanceof BetalingsverplichtingOpgelegdEntity bvo) {
            return map(bvo);
        }

        if (event instanceof FinancieleVerplichtingOpgelegdEntity fvo) {
            return map(fvo);
        }

        return null;
    }
}
