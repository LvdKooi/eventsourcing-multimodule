package nl.cjib.eventsourcing.core.usecases;

import nl.cjib.eventsourcing.core.command.BepaalFinancieleVerplichtingCommand;
import nl.cjib.eventsourcing.core.domain.aggregator.aggregate.FinancieleVerplichting;

public interface BepaalFinancieleVerplichtingUseCase {

    FinancieleVerplichting handle(BepaalFinancieleVerplichtingCommand command);
}
