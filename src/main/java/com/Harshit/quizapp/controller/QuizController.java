package com.Harshit.quizapp.controller;

import com.Harshit.quizapp.model.QuestionWrapper;
import com.Harshit.quizapp.model.Questions;
import com.Harshit.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("quiz/v1")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int questionNum, @RequestParam String title)
    {
        return quizService.createQuiz(category,questionNum,title);
    }

    @GetMapping("getQuiz/title/{title}")
    public ResponseEntity<List<Questions>> getQuizByTitle(@PathVariable("title") String title){
        return quizService.getQuizByTitle(title);
    }

    @GetMapping("getQuiz/id/{id}")
    public ResponseEntity<List<Questions>> getQuizById(@PathVariable("id") int id){
        return quizService.getQuizById(id);
    }
    @GetMapping("getQuiz/questions/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") int id){
        return quizService.getQuizByQuestions(id);
    }
}
