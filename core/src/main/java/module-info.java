module nl.cjib.eventsourcing.core {
    exports nl.cjib.eventsourcing.exception;
    exports nl.cjib.eventsourcing.domain.aggregator.aggregate;
    exports nl.cjib.eventsourcing.domain.event;
    exports nl.cjib.eventsourcing.usecases;
    exports nl.cjib.eventsourcing.command;
    exports nl.cjib.eventsourcing.domain.mapper to spring.beans;
    requires nl.cjib.eventsourcing.infra;
    requires org.mapstruct;
    requires spring.context;
    requires spring.beans;
    requires lombok;
}