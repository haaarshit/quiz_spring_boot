package com.Harshit.quizapp.dao;

import com.Harshit.quizapp.model.QuestionWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Harshit.quizapp.model.Quiz;
@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {
    Quiz findByTitle(String title);


}
