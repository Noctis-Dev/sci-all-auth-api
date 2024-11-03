package org.noctisdev.sciallauthapi.domain.broker;

import org.noctisdev.sciallauthapi.domain.events.NotificationEmailEvent;
import org.noctisdev.sciallauthapi.domain.events.NotificationWhatsappEvent;

public interface IMessageProducer {

    void sendEmailNotification(NotificationEmailEvent event);
    void sendWhatsappNotification(NotificationWhatsappEvent event);

}
