module nl.cjib.eventsourcing.infra {
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;
    requires spring.data.jpa;
    requires spring.context;
    requires nl.cjib.eventsourcing.core;
    requires org.mapstruct;
    exports nl.cjib.eventsourcing.mapper to spring.beans;
    exports nl.cjib.eventsourcing.entity to nl.cjib.eventsourcing.core;
    opens nl.cjib.eventsourcing.entity to org.hibernate.orm.core, spring.core;
    exports nl.cjib.eventsourcing.dao to nl.cjib.eventsourcing.core, spring.beans;
}