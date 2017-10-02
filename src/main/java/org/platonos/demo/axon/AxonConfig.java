package org.platonos.demo.axon;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.spring.config.AxonConfiguration;
import org.platonos.demo.axon.Commandhandler.DrinksCommandHandler;
import org.platonos.demo.axon.command.DrinkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableAxon
@Configuration
public class AxonConfig {

    @Autowired
    private AxonConfiguration axonConfiguration;
    @Autowired
    private EventBus eventBus;

    @Bean
    DrinksCommandHandler drinksCommandHandler() {
        return new DrinksCommandHandler(axonConfiguration.repository(DrinkOrder.class), eventBus);
    }

}
