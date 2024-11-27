package nl.cjib.eventsourcing.infra.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.DiscriminatorFormula;

import java.time.LocalDate;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@DiscriminatorFormula("event_type")
public abstract class EventEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long eventId;

    @EqualsAndHashCode.Include
    private LocalDate eventDate;

    private String eventType;

    private String verplichtingsnummer;
}