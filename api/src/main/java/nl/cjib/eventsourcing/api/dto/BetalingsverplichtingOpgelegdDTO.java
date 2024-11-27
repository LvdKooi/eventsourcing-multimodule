package nl.cjib.eventsourcing.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class BetalingsverplichtingOpgelegdDTO extends EventDTO {

    private String betalingskenmerk;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate vervalDatum;
    private String omschrijving;
    private String betaalwijze;
    private BigDecimal bedrag;
    private String verplichtingsnummer;
}
