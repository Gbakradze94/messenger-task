package org.epam.training.mode;

import org.epam.training.Template;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Scanner;
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
}
