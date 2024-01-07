package com.Harshit.quizapp.dao;


import com.Harshit.quizapp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> { // JpaRepository takes Class that is mapping
                                                                        // to table and type of primary key
    List<Questions> findByCategory(String category);

//    (value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM()
    @Query(value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :quesitonNo",nativeQuery = true)
    List<Questions> findRandomQuestionByCategory(String category,int quesitonNo);
}