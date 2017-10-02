package org.platonos.demo.axon.Commandhandler;

import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;
import org.platonos.demo.axon.command.DrinkOrder;

public class DrinksCommandHandler {

    private final Repository<DrinkOrder> repository;
    private final EventBus eventBus;

    public DrinksCommandHandler(final Repository<DrinkOrder> repository, final EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }
}
