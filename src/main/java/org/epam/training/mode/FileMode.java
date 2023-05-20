package org.epam.training.mode;

import org.epam.training.Client;
import org.epam.training.Template;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileMode implements Mode {
    private Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    public FileMode(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        System.out.println("File mode initiated");
        System.out.println("Enter path for input file: ");
        String inputFilePath = scanner.nextLine();
        System.out.println("Provide path for output file: ");
        String outputFilePath = scanner.nextLine();

        List<String> inputFileLines = new ArrayList<>();
        try {
            inputFileLines = Files.lines(Paths.get(inputFilePath)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String text = extractTextFromFile(inputFileLines);

    }

    private String extractTextFromFile(List<String> inputFileLines) {
        List<String> text = new ArrayList<>();
        for (int i = 0; i < inputFileLines.size(); i++) {
            text.add(inputFileLines.get(i));
        }
        return text.stream()
                .reduce((initialLine, currentLine) -> initialLine + "\n" + currentLine)
                .get();
    }
    public Client createClient(Template template) {
        return null;
    }
}
