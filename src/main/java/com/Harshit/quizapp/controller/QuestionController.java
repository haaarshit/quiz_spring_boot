package com.Harshit.quizapp.controller;

import com.Harshit.quizapp.model.Questions;
import com.Harshit.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question/v1/")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Questions> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("allQuestions/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable("category") String category){
        return questionService.getQuestionsByCategory(category);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }

    @PutMapping("update")
    public  ResponseEntity<String> updateQuestion(@RequestBody Questions q){
        return questionService.updateQuestion(q);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String>  deleteQuestionById(@PathVariable("id") int id){
            return questionService.deleteQuestionById(id);
    }

}