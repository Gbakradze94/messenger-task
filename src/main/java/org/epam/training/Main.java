package org.epam.training;

import org.epam.training.mode.Mode;
import org.epam.training.mode.ModeFactory;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    private static void displayMessage() {
        System.out.println("Welcome to messenger app");
        System.out.println("Please, select application mode");
        System.out.println("For console mode enter 1");
        System.out.println("For file mode enter 2");
    }



    public static void main(String[] args) {
        ModeFactory modeFactory = new ModeFactory();
        Mode mode;
        displayMessage();
        while (true) {
        }
    }
}
