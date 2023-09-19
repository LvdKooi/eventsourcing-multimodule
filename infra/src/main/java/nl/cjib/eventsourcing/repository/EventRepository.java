package nl.cjib.eventsourcing.repository;

import nl.cjib.eventsourcing.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Set<EventEntity> findAllByVerplichtingsnummer(String verplichtingsnummer);
}
