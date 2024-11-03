package org.noctisdev.sciallauthapi.infraestructure.broker;

import lombok.extern.slf4j.Slf4j;
import org.noctisdev.sciallauthapi.domain.broker.IMessageProducer;
import org.noctisdev.sciallauthapi.domain.events.NotificationEmailEvent;
import org.noctisdev.sciallauthapi.domain.events.NotificationWhatsappEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageProducer implements IMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendEmailNotification(NotificationEmailEvent event) {
        rabbitTemplate.convertAndSend("EmailNotification", event);
    }

    @Override
    public void sendWhatsappNotification(NotificationWhatsappEvent event) {
        rabbitTemplate.convertAndSend("WhatsappNotification", event);
    }
}
