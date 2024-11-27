package nl.cjib.eventsourcing.infra.repository;

import nl.cjib.eventsourcing.infra.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Set<EventEntity> findAllByVerplichtingsnummer(String verplichtingsnummer);
}
