module nl.cjib.eventsourcing.core {
    exports nl.cjib.eventsourcing.core.exception;
    exports nl.cjib.eventsourcing.core.domain.aggregator.aggregate;
    exports nl.cjib.eventsourcing.core.domain.event;
    exports nl.cjib.eventsourcing.core.usecases;
    exports nl.cjib.eventsourcing.core.command;
    exports nl.cjib.eventsourcing.core.domain.dao;
    requires org.mapstruct;
    requires spring.context;
    requires spring.beans;
    requires lombok;
}