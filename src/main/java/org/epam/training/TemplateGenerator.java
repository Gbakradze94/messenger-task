package org.epam.training;

import java.util.Map;

public class TemplateGenerator {

    public String generateMessage(Client client, Template template) {
        Map<String, String> inputKeyValues = client.getUserInputKeyValue();
        Map<String, String> keyValuesInTemplate = template.getKeyValuePairs();
        String messageBody = template.getBody();
        int inputValueCounter = 0;
        for (Map.Entry<String, String> entry : inputKeyValues.entrySet()) {
            if (keyValuesInTemplate.containsKey(entry.getKey())) {
                messageBody = messageBody.replace("#{" + entry.getKey() + "}", entry.getValue());
                inputValueCounter++;
            }
        }

        if (keyValuesInTemplate.size() == inputValueCounter) {
            return messageBody;
        } else {
            throw new NotAllInputValuesProvidedException("Not all values are provided");
        }
    }
}
