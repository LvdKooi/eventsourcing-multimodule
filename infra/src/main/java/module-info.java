module nl.cjib.eventsourcing.infra {
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;
    requires spring.data.jpa;
    requires spring.context;
    requires nl.cjib.eventsourcing.core;
    requires org.mapstruct;
    exports nl.cjib.eventsourcing.infra.mapper to spring.beans;
    exports nl.cjib.eventsourcing.infra.entity to nl.cjib.eventsourcing.core;
    opens nl.cjib.eventsourcing.infra.entity to org.hibernate.orm.core, spring.core;
    exports nl.cjib.eventsourcing.infra.dao to nl.cjib.eventsourcing.core, spring.beans;
}