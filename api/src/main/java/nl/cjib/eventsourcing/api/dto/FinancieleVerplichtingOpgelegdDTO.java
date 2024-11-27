package nl.cjib.eventsourcing.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class FinancieleVerplichtingOpgelegdDTO extends EventDTO {
    private String verplichtingsnummer;
    private String omschrijving;
    private BigDecimal bedrag;
}
