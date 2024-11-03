package org.noctisdev.sciallauthapi.domain.events;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NotificationWhatsappEvent {

    @NotNull
    private String destination;

    @NotNull
    private String message;

}
