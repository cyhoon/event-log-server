package net.povv.event.eventlogserver.domain.event.command;

import org.springframework.context.ApplicationEvent;

import java.util.Date;

public class TrackEventCommand extends ApplicationEvent {
    public final String userId;
    public final String name;
    public final Object property;
    public final Date createDate;

    public TrackEventCommand(Object source, String userId, String name, Object property, Date createDate) {
        super(source);
        this.userId = userId;
        this.name = name;
        this.property = property;
        this.createDate = createDate;
    }
}
