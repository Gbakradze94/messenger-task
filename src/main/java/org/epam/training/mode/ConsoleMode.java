package org.epam.training.mode;

import org.epam.training.Client;
import org.epam.training.Messenger;
import org.epam.training.TemplateGenerator;
import org.epam.training.server.ConsoleMessageServer;
import org.epam.training.server.MessageServer;
import org.epam.training.Template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMode implements Mode {
    private final Scanner scanner;

    public ConsoleMode(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        // Console mode
        System.out.println("Console mode initiated");

        MessageServer messageServer = new ConsoleMessageServer();
        TemplateGenerator templateGenerator = new TemplateGenerator();
        Messenger messenger = new Messenger(messageServer, templateGenerator);

        Template template = createTemplate();
        Client client = createClient(template);
        messenger.sendMessage(client, template);
    }

    public Client createClient(Template template) {
        Map<String, String> userInputValues = new HashMap<>();
        for (String key : template.getKeyValuePairs().keySet()) {
            String currentKeyValue = scanner.nextLine();
            userInputValues.put(key, currentKeyValue);
        }

        Client client = new Client();
        client.setUserInputKeyValue(userInputValues);
        client.setAddress(getAddresses());
        return client;
    }

    private String getAddresses() {
        System.out.println("Enter recipient's address");
        System.out.println("Press enter twice to proceed");
        List<String> addresses = new ArrayList<>();
        while (true) {
            String address = scanner.nextLine();
            if (address.length() > 0) {
                addresses.add(address);
            } else {
                break;
            }
        }
        StringBuilder addressBuilder = new StringBuilder();
        addresses.forEach(address -> addressBuilder.append(address).append(""));
        return addressBuilder.toString();
    }

    public Template createTemplate() {
        Template template = new Template();
        StringBuilder templateBodyBuilder = new StringBuilder();
        System.out.println("Type template body in the console");
        System.out.println("Example: My name is #{name} and I am #{age} years old");
        System.out.println("After entering the template, press enter twice to continue");
        while (true) {
            String line = scanner.nextLine();
            if (line.length() == 0) {
                break;
            }
            templateBodyBuilder.append(line);
        }
        template.setBody(templateBodyBuilder.toString());
        return template;
    }
}
