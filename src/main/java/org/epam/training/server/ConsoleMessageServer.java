package org.epam.training.server;

import java.util.Arrays;

public class ConsoleMessageServer implements MessageServer {
    @Override
    public void sendMessage(String address, String message) {
        String[] addresses = address.split(",");
        Arrays.stream(addresses)
                .forEach(destinationAddress -> {
                    System.out.println("Message body: " + message);
                    System.out.println("Address: " + destinationAddress);
                });
    }
}
