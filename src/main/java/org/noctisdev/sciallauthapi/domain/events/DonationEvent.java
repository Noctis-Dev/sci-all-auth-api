package org.noctisdev.sciallauthapi.domain.events;

import org.springframework.context.ApplicationEvent;

public class DonationEvent extends ApplicationEvent {

    public DonationEvent(Object source) {
        super(source);
    }
}
