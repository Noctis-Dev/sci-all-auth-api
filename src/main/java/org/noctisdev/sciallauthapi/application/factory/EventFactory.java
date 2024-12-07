package org.noctisdev.sciallauthapi.application.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.noctisdev.sciallauthapi.domain.broker.IMessageProducer;
import org.noctisdev.sciallauthapi.domain.events.EventType;
import org.noctisdev.sciallauthapi.domain.events.NotificationEvent;

@Builder @AllArgsConstructor @NoArgsConstructor @Setter
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

        switch (type) {
            case EMAIL:
                event.setDestination(email);
                break;
            case WHATSAPP:
                event.setDestination(phoneNumber);
                break;
            default:
                throw new IllegalArgumentException("Invalid notification type");
        }

        event.setType(type);
        event.setSubject(subject);
        event.setMessage(message);

        return () -> producer.sendNotification(event);
    }
}
