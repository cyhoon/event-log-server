package net.povv.event.eventlogserver.controllers.dto;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
public class TrackEventReq {
    @NotNull
    public final String userId;

    @NotNull
    public final String name;

    @NotNull
    public final Object property;

    @NotNull
    public final Date createDate;
}
