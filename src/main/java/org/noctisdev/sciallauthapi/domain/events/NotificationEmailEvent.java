package org.noctisdev.sciallauthapi.domain.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter @Setter
public class NotificationEmailEvent {
    private String to;
    private String subject;
    private String body;
}
