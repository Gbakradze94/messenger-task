package org.epam.training.template;

import org.epam.training.Client;
import org.epam.training.Template;
import org.epam.training.TemplateGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TemplateGeneratorTest {
    @Mock
    Template template;
    @Mock
    Client client;

    @DisplayName("user provides only all the necessary values")
    @Tag("key_value")
    @Test
    void whenClientProvidesPlaceholdersGenerateMessage() {
        Map<String,String> clientProvidedKeyValues = new HashMap<>();
        clientProvidedKeyValues.put("hobby", "coding");
        clientProvidedKeyValues.put("name", "Giorgi");
        when(client.getUserInputKeyValue()).thenReturn(clientProvidedKeyValues);

        Map<String,String> templateKeyValues = new HashMap<>();
        templateKeyValues.put("hobby",null);
        templateKeyValues.put("name",null);
        when(template.getKeyValuePairs()).thenReturn(templateKeyValues);
        String templateBody = "Hello, my name is #{name}. My hobby is #{hobby}.";
        when(template.getBody()).thenReturn(templateBody);

        TemplateGenerator templateGenerator = new TemplateGenerator();
        String generatedMessage = templateGenerator.generateMessage(client, template);
        assertEquals("Hello, my name is Giorgi. My hobby is coding.", generatedMessage);
    }


}
