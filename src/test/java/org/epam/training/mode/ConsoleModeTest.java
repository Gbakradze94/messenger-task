package org.epam.training.mode;

import org.epam.training.Client;
import org.epam.training.Template;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsoleModeTest {

    @Test
    void whenConsoleModeCheckUserInputForTemplateBody() {
        String userInput = "My name is #{name} and I am #{age} years old.";
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn(userInput).thenReturn("");
        ConsoleMode consoleMode = new ConsoleMode(scanner);
        Template template = consoleMode.createTemplate();
        assertEquals(userInput, template.getBody());
    }

    @Test
    void whenConsoleModeValidKeyValuePairsForUserInputs() {
        String templateString = "My name is #{name} and I am a #{job}";
        String input1 = "Giorgi";
        String input2 = "Software Engineer";
        Scanner scanner = mock(Scanner.class);

        when(scanner.nextLine()).thenReturn(templateString)
                .thenReturn("")
                .thenReturn(input1)
                .thenReturn(input2)
                .thenReturn("");
        ConsoleMode consoleMode = new ConsoleMode(scanner);
        Template template = consoleMode.createTemplate();

        Client client = consoleMode.createClient(template);

        Map<String, String> userInputKeyValues = client.getUserInputKeyValue();
        assertAll("Check valid key values",
                () -> assertEquals("Software Engineer", userInputKeyValues.get("job")),
                () -> assertEquals("Giorgi", userInputKeyValues.get("name"))
        );
    }
}
