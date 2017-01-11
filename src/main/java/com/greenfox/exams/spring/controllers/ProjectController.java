package com.greenfox.exams.spring.controllers;

import com.greenfox.exams.spring.domain.Feedback;
import com.greenfox.exams.spring.service.FeedbackService;
import com.greenfox.exams.spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    private String errorMessageToShow = "";
    private FeedbackService feedbackService;
    private ProjectService projectService;

    @Autowired
    public ProjectController(FeedbackService feedbackService,
                             ProjectService projectService) {
        this.feedbackService = feedbackService;
        this.projectService = projectService;
    }

    @RequestMapping(value = {"", "/", "/index"})
    public String showIndex(Model model) {
        model.addAttribute("error", errorMessageToShow);
        model.addAttribute("feedback", new Feedback());
        return "index";
    }

    @PostMapping(value = "/submit")
    public String submitFeedback(@ModelAttribute("feedback") Feedback feedback) {
        errorMessageToShow = feedbackService.validate(feedback);
        if (feedBackIsValid()) {
            feedbackService.saveFeedback(feedback);
            return "redirect:/thankyou";
        } else {
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "/thankyou")
    public String showThankYouPage(Model model){
        model.addAttribute("projects", projectService.obtainAllProjects());
        return "thankyou";
    }

    private boolean feedBackIsValid() {
        return errorMessageToShow.equals("");
    }

}
