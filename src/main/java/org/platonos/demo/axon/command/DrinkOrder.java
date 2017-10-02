package org.platonos.demo.axon.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.platonos.demo.axon.event.OrderDrinkEvent;

@Aggregate
public class DrinkOrder {

    @AggregateIdentifier
    private String id;
    private String order;

    @CommandHandler
    public DrinkOrder(final OrderDrinkCommand orderDrinkCommand) {
        AggregateLifecycle.apply(new OrderDrinkEvent(
                orderDrinkCommand.getId(),
                orderDrinkCommand.getOrder()
        ));
    }

    @EventSourcingHandler
    public void on(final OrderDrinkEvent orderDrinkEvent) {
        System.out.println("DrinkOrder handle order " + orderDrinkEvent.getOrder());

        this.id = orderDrinkEvent.getId();
        this.order = orderDrinkEvent.getOrder();
    }

}
