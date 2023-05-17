package org.epam.training;

public class Messenger {

    private MessageServer messageServer;
    private TemplateGenerator templateGenerator;

    public Messenger(MessageServer messageServer,
                     TemplateGenerator templateGenerator) {

    }

    public void sendMessage(Client client, Template template) {
        String message = templateGenerator.generateMessage(client, template);
        messageServer.sendMessage(client.getAddress(),message);
    }
}