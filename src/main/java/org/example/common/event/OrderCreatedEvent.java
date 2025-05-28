package org.example.common.event;


import java.time.LocalDateTime;

public class OrderCreatedEvent extends Event{
    private final String id;
    private final String clientName;

    public OrderCreatedEvent(String id, String clientName) {
        super();
        this.id = id;
        this.clientName = clientName;
    }

    public String getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }
}
