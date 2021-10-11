package net.povv.event.eventlogserver.controllers;

import lombok.RequiredArgsConstructor;
import net.povv.event.eventlogserver.domain.event.command.TrackEventCommand;
import net.povv.event.eventlogserver.controllers.dto.TrackEventReq;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventTrackingController {
    private final ApplicationEventPublisher eventPublisher;

    @PostMapping("/t")
    public String trackEvent(@Valid @RequestBody TrackEventReq req) {
        TrackEventCommand command = new TrackEventCommand(this, req.userId, req.name, req.property, req.createDate);

        eventPublisher.publishEvent(command);

        return "success";
    }
}
