package com.quizhub.brainteaser;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class QuestionAnswerProvider {

    // Provide a list of questions and answers
    public static List<Map.Entry<String, String>> getQuestionsAndAnswers() {
        return Arrays.asList(
                new AbstractMap.SimpleEntry<>("What has keys but can't open locks?", "Piano"),
                new AbstractMap.SimpleEntry<>("What has hands but can't clap?", "Clock"),
                new AbstractMap.SimpleEntry<>("What has a head, a tail, but no body?", "Coin"),
                new AbstractMap.SimpleEntry<>("What gets wetter as it dries?", "Towel"),
                new AbstractMap.SimpleEntry<>("What has many teeth but can't bite?", "Comb"),
                new AbstractMap.SimpleEntry<>("What can travel around the world while staying in a corner?", "Stamp"),
                new AbstractMap.SimpleEntry<>("What has a neck but no head?", "Bottle"),
                new AbstractMap.SimpleEntry<>("What has an eye but can't see?", "Needle"),
                new AbstractMap.SimpleEntry<>("What is full of holes but still holds water?", "Sponge"),
                new AbstractMap.SimpleEntry<>("What is so fragile that saying its name breaks it?", "Silence")
        );
    }
}
