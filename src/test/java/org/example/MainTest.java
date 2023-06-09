package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.Main.*;

class MainTest {

    @Test
    public void testCalculateSimilarity() {
        String text1 = "Hello world";
        String text2 = "Hello universe";
        double expectedSimilarity = 0.5;
        double actualSimilarity = calculateSimilarity(text1, text2);
        Assertions.assertEquals(expectedSimilarity, actualSimilarity, 0.0001);
    }
    @Test
    public void testCalculateSpamProbabilities() {
        List<String> emailBodyTexts = new ArrayList<>();
        emailBodyTexts.add("Hello world");
        emailBodyTexts.add("Hello universe");
        emailBodyTexts.add("Hi fredy");
        emailBodyTexts.add("Hi java");
        emailBodyTexts.add("Greetings");

        Map<String, List> expectedSpamProbabilities = new HashMap<>();
        expectedSpamProbabilities.put("Hello world",List.of(0.5,1));
        expectedSpamProbabilities.put("Hello universe",List.of(0.5,1));
        expectedSpamProbabilities.put("Hi fredy", List.of(0.5,1));
        expectedSpamProbabilities.put("Hi java", List.of(0.5,1));
        expectedSpamProbabilities.put("Greetings", List.of(0.0,0));

        Map<String, List> actualSpamProbabilities = scanMails(emailBodyTexts);

        Assertions.assertEquals(expectedSpamProbabilities, actualSpamProbabilities);
    }


}