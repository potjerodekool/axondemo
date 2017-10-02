package org.platonos.demo.axon.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.platonos.demo.axon.command.OrderDrinkCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("/drinks")
public class DriksController {

    private final CommandGateway commandGateway;

    public DriksController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<String> options() {
        return Arrays.asList("Coffee","Trea");
    }

    @RequestMapping(value = "order",method = RequestMethod.GET)
    public void order(final @RequestParam(name = "order") String order) {
        System.out.println("Received order " + order);
        final String id = UUID.randomUUID().toString();
        commandGateway.send(new OrderDrinkCommand(id, order));
    }
}
