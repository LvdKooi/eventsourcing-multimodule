package nl.cjib.eventsourcing.dto;

import lombok.Data;

@Data
public class BetalingsverplichtingIngetrokkenDTO extends EventDTO {
    private String betalingskenmerk;
}
