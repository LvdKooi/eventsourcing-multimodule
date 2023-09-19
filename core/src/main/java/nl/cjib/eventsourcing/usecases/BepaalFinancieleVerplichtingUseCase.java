package nl.cjib.eventsourcing.usecases;

import nl.cjib.eventsourcing.command.BepaalFinancieleVerplichtingCommand;
import nl.cjib.eventsourcing.domain.aggregator.aggregate.FinancieleVerplichting;

public interface BepaalFinancieleVerplichtingUseCase {

    FinancieleVerplichting handle(BepaalFinancieleVerplichtingCommand command);
}
