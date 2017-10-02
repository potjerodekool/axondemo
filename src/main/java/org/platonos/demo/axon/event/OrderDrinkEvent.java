package org.platonos.demo.axon.event;

public class OrderDrinkEvent {

    private final String id;
    private final String order;

    public OrderDrinkEvent(final String id,
                           final String order) {
        this.id = id;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public String getOrder() {
        return order;
    }
}
