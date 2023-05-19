package org.epam.training.mode;

import org.epam.training.Client;
import org.epam.training.Template;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileMode implements Mode {
    private Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    public FileMode(Scanner scanner) {
        this.scanner = scanner;
    }
    @Override
    public void run() {
        // File mode goes here
        System.out.println("File mode initiated");
    }

    public Client createClient(Template template) {
        return null;
    }
}
