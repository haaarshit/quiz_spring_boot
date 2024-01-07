package com.Harshit.quizapp.service;
import com.Harshit.quizapp.dao.QuestionDao;
import com.Harshit.quizapp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    // get all questions (GET)
    public List<Questions> getAllQuestion(){
        return questionDao.findAll();
    }

    // get all questions based on category (GET)
    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category){
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<Questions>(),HttpStatus.BAD_REQUEST);
    }

    // add questions (POST)
    public ResponseEntity<String> addQuestion(Questions question){
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Got some error",HttpStatus.BAD_REQUEST);
    }

    // update questions (PUT)
    public ResponseEntity<String>  updateQuestion(Questions update){
        try{
            questionDao.save(update);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Got some error",HttpStatus.BAD_REQUEST);
    }

    // delete questions (DELETE)
    public ResponseEntity<String> deleteQuestionById(int id){
        try{
        questionDao.deleteById(id);
        return new ResponseEntity<>("Success",HttpStatus.OK);
        }
         catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Got some error",HttpStatus.BAD_REQUEST);
    }

}
