package nl.cjib.eventsourcing.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BetalingsverplichtingIngetrokkenDTO extends EventDTO {
    private String betalingskenmerk;
}
