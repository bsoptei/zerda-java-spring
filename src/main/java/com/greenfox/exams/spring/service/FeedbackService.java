package com.greenfox.exams.spring.service;

import com.greenfox.exams.spring.domain.Feedback;
import com.greenfox.exams.spring.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class FeedbackService {

    private FeedbackRepo feedbackRepo;

    @Autowired
    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    public void saveFeedback(Feedback feedback) {
        feedbackRepo.save(feedback);
    }

    public String validate(Feedback feedback) {
        return generateEmailErrorMessage(feedback) +
                generateOpinionErrorMessage(feedback) +
                generateRatingErrorMessage(feedback);
    }

    private String generateEmailErrorMessage(Feedback feedback) {
        return (isEmailValid(feedback)) ? "" : "Email adress is not valid!";
    }

    private String generateOpinionErrorMessage(Feedback feedback) {
        return (isOpinionGoodEnough(feedback)) ? "" : "Your opinion is too degrading!";
    }

    private String generateRatingErrorMessage(Feedback feedback) {
        return (isRatingHighEnough(feedback)) ? "": "Your rating is too low!";
    }

    private boolean isEmailValid(Feedback feedback) {
        return (feedback.getEmail().contains("@") && feedback.getEmail().contains("."));
    }

    private boolean isOpinionGoodEnough(Feedback feedback) {
        ArrayList<String> goodOpinionKeyWords = new ArrayList<>(Arrays.asList(
                "amazing", "awesome", "blithesome", "excellent", "fabulous",
                "fantastic", "favorable", "fortuitous", "great", "incredible",
                "ineffable", "mirthful", "outstanding", "perfect", "propitious",
                "remarkable", "smart", "spectacular", "splendid", "stellar",
                "stupendous", "super", "ultimate", "unbelievable", "wondrous"));
        int numberOfGoodKeyWords = 0;
        for (String keyWord : goodOpinionKeyWords) {
            if (feedback.getOpinion().contains(keyWord)) {
                numberOfGoodKeyWords++;
            }
        }
        return numberOfGoodKeyWords >= 3;
    }

    private boolean isRatingHighEnough(Feedback feedback) {
        return feedback.getRating() >= 10;
    }
}
