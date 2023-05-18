package org.epam.training.mode;

import org.epam.training.Template;
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
