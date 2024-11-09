package org.noctisdev.sciallauthapi.domain.broker;

import org.noctisdev.sciallauthapi.domain.events.NotificationEvent;

public interface IMessageProducer {

    void sendNotification(NotificationEvent event);
}
