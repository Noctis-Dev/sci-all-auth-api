package org.noctisdev.sciallauthapi.infraestructure.broker;

import org.noctisdev.sciallauthapi.domain.broker.IMessageProducer;
import org.noctisdev.sciallauthapi.domain.events.NotificationEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer implements IMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendNotification(NotificationEvent event) {
        rabbitTemplate.convertAndSend("NotificationEvent", event);
    }
}
