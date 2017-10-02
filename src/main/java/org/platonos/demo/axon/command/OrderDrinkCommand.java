package org.platonos.demo.axon.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class OrderDrinkCommand {

    @TargetAggregateIdentifier
    private final String id;
    private final String order;

    public OrderDrinkCommand(final String id, final String order) {
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
