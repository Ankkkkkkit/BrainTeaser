package com.quizhub.brainteaser.service;

import com.quizhub.brainteaser.QuestionAnswerProvider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class BrainTeaserService {

    private final List<Map.Entry<String, String>> allTeasers;

    // Constructor to initialize the list of all teasers from the provider
    public BrainTeaserService() {
        this.allTeasers = QuestionAnswerProvider.getQuestionsAndAnswers();
    }

    // Method to get a random set of teasers
    public List<Map.Entry<String, String>> getRandomTeasers(int numberOfQuestions) {
        Random rand = new Random();
        List<Map.Entry<String, String>> selectedTeasers = new ArrayList<>();
        while (selectedTeasers.size() < numberOfQuestions && !allTeasers.isEmpty()) {
            Map.Entry<String, String> teaser = allTeasers.get(rand.nextInt(allTeasers.size()));
            if (!selectedTeasers.contains(teaser)) {
                selectedTeasers.add(teaser);
            }
        }
        return selectedTeasers;
    }
}
