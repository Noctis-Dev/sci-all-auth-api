package org.noctisdev.sciallauthapi.application.factory;

import lombok.Builder;
import org.noctisdev.sciallauthapi.domain.broker.IMessageProducer;
import org.noctisdev.sciallauthapi.domain.events.EventType;
import org.noctisdev.sciallauthapi.domain.events.NotificationEvent;

@Builder
public class EventFactory {

    private IMessageProducer producer;
    private EventType type;
    private String email;
    private String phoneNumber;
    private String message;
    private String subject;

    public interface Notification {
        void send();
    }

    public Notification getNotification() {
        NotificationEvent event = new NotificationEvent();
        event.setType(type);
        event.setDestination(email);
        event.setSubject(subject);
        event.setMessage(message);

        return () -> producer.sendNotification(event);
    }
}
