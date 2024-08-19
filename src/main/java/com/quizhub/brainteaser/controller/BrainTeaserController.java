package com.quizhub.brainteaser.controller;

import com.quizhub.brainteaser.service.BrainTeaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/takeQuiz")
public class BrainTeaserController {

    @Autowired
    private BrainTeaserService brainTeaserService;

    @GetMapping("/start")
    public String startQuiz(Model model) {
        // Get 5 random questions
        List<Map.Entry<String, String>> teasers = brainTeaserService.getRandomTeasers(5);
        model.addAttribute("teasers", teasers);
        model.addAttribute("feedback", "");
        model.addAttribute("currentQuestionIndex", 0);
        return "teaser";
    }

    @PostMapping("/submit")
    public String submitAnswers(@RequestParam Map<String, String> params, Model model) {
        // Extract the correct answers and user answers from parameters
        List<Map.Entry<String, String>> teasers = brainTeaserService.getRandomTeasers(5); // Retrieve the same set
        int score = 0;

        for (Map.Entry<String, String> teaser : teasers) {
            String question = teaser.getKey();
            String correctAnswer = teaser.getValue();
            String userAnswer = params.get("answer_" + question); // Use question text to find the answer

            if (userAnswer != null && userAnswer.trim().equalsIgnoreCase(correctAnswer)) {
                score++;
            }
        }

        model.addAttribute("score", score);
        model.addAttribute("totalQuestions", teasers.size());
        model.addAttribute("feedback", "Your score is " + score + " out of " + teasers.size() + ".");
        return "teaser";
    }
}
