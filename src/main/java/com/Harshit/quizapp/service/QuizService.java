package com.Harshit.quizapp.service;

import com.Harshit.quizapp.dao.QuestionDao;
import com.Harshit.quizapp.dao.QuizDao;
import com.Harshit.quizapp.model.QuestionWrapper;
import com.Harshit.quizapp.model.Questions;
import com.Harshit.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuestionDao questionDao;
    @Autowired
    QuizDao quizDao;
    public ResponseEntity<String> createQuiz(String category,int questionNo,String title){
        List<Questions> questionsList = questionDao.findRandomQuestionByCategory(category,questionNo);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionsList);
        quizDao.save(quiz);
        return new ResponseEntity<>("quiz", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Questions>> getQuizByTitle(String title){
        return new ResponseEntity<>(quizDao.findByTitle(title).getQuestions(),HttpStatus.OK);
    }

    public ResponseEntity<List<Questions>> getQuizById(int id){
        return new ResponseEntity<>(quizDao.findById(id).get().getQuestions(), HttpStatus.OK);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizByQuestions(int id){
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questions> questionsList = quiz.get().getQuestions();
        List<QuestionWrapper> questionsWrapperList = new ArrayList<>(questionsList.size());
        for(Questions q : questionsList){
//            String questionTitle,option1,option2,option3,option4,category,difficultyLevel;
//            int qId ;
//            // get all data from question except right answer
//            qId = questionsList.get(i).getId();
//            questionTitle = questionsList.get(i).getQuestionTitle();
//            option1 = questionsList.get(i).getOption1();
//            option2 = questionsList.get(i).getOption2();
//            option3 = questionsList.get(i).getOption3();
//            option4 = questionsList.get(i).getOption4();
//            category = questionsList.get(i).getCategory();
//            difficultyLevel = questionsList.get(i).getDifficultyLevel();
//            // set questionWrapper
//            questionsWrapperList.set(i,new QuestionWrapper(qId,questionTitle,option1,option2,option3,option4,category,difficultyLevel));

            QuestionWrapper question = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getCategory(),q.getDifficultyLevel());
            questionsWrapperList.add(question);
        }
        return new ResponseEntity<>(questionsWrapperList,HttpStatus.OK);
    }
}