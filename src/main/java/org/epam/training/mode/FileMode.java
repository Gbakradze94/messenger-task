package org.epam.training.mode;

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
}
