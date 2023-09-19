package nl.cjib.eventsourcing.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FinancieleVerplichtingOpgelegdDTO extends EventDTO {
    private String verplichtingsnummer;
    private String omschrijving;
    private BigDecimal bedrag;
}
