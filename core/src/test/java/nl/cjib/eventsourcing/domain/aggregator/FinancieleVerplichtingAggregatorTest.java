package nl.cjib.eventsourcing.domain.aggregator;

import nl.cjib.eventsourcing.domain.event.BetalingsverplichtingIngetrokken;
import nl.cjib.eventsourcing.domain.event.BetalingsverplichtingOpgelegd;
import nl.cjib.eventsourcing.domain.event.Event;
import nl.cjib.eventsourcing.domain.event.FinancieleVerplichtingOpgelegd;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class FinancieleVerplichtingAggregatorTest {

    @Test
    void happyFlow_alleEventsWarenVoorPeilDatum() {
        var uitkomst = FinancieleVerplichtingAggregator.aggregateEvents(referenceSet(), LocalDate.now());

        AssertionsForClassTypes.assertThat(uitkomst).isNotNull();
        AssertionsForClassTypes.assertThat(uitkomst.openstaandSaldo()).isEqualTo(BigDecimal.valueOf(16500));
        AssertionsForClassTypes.assertThat(uitkomst.omschrijving()).isEqualTo("Verkeersboete");
        AssertionsForInterfaceTypes.assertThat(uitkomst.betalingsverplichtingen()).hasSize(1);
        AssertionsForInterfaceTypes.assertThat(uitkomst.gebeurtenissen()).hasSize(6);
    }

    @Test
    void happyFlow_eenAantalEventsWarenNaPeilDatum() {
        var uitkomst = FinancieleVerplichtingAggregator.aggregateEvents(referenceSet(), LocalDate.of(2023, 5, 31));

        AssertionsForClassTypes.assertThat(uitkomst).isNotNull();
        AssertionsForClassTypes.assertThat(uitkomst.openstaandSaldo()).isEqualTo(BigDecimal.valueOf(11300));
        AssertionsForClassTypes.assertThat(uitkomst.omschrijving()).isEqualTo("Verkeersboete");
        AssertionsForInterfaceTypes.assertThat(uitkomst.betalingsverplichtingen()).hasSize(1);
        AssertionsForInterfaceTypes.assertThat(uitkomst.gebeurtenissen()).hasSize(3);
    }

    private static Set<Event> referenceSet() {
        return Set.of(
                new FinancieleVerplichtingOpgelegd("EVENT1", LocalDate.of(2023, 5, 1), "VERPLICHTINGSNUMMER1", "Verkeersboete", BigDecimal.valueOf(10400)),
                new FinancieleVerplichtingOpgelegd("EVENT2", LocalDate.of(2023, 5, 1), "VERPLICHTINGSNUMMER1", "Administratiekosten", BigDecimal.valueOf(900)),
                new BetalingsverplichtingOpgelegd("EVENT3", LocalDate.of(2023, 5, 1), "VERPLICHTINGSNUMMER1", "BETALINGSKENMERK", LocalDate.of(2023, 6, 1), "Direct betalen", "CONTANT", BigDecimal.valueOf(11300)),
                new FinancieleVerplichtingOpgelegd("EVENT4", LocalDate.of(2023, 6, 1), "VERPLICHTINGSNUMMER1", "Kosten eerste aanmaning", BigDecimal.valueOf(5200)),
                new BetalingsverplichtingIngetrokken("EVENT5", LocalDate.of(2023, 6, 1), "VERPLICHTINGSNUMMER1", "BETALINGSKENMERK"),
                new BetalingsverplichtingOpgelegd("EVENT3", LocalDate.of(2023, 6, 1), "VERPLICHTINGSNUMMER1", "BETALINGSKENMERK2", LocalDate.of(2023, 6, 1), "Direct betalen", "CONTANT", BigDecimal.valueOf(16500)
                )
        );
    }
}