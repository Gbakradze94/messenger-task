package org.epam.training.mode;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.epam.training.mode.MessengerMode.CONSOLE;

public class ModeFactory {
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    public Mode initMode(String type) {
        if (MessengerMode.FILE.equals(type)) {
            return new FileMode(scanner);
        }
        return new ConsoleMode(scanner);
    }
}
