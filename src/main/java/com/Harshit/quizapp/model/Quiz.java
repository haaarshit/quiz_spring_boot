package com.Harshit.quizapp.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

//    @JoinTable(name = "quiz_questions",joinColumns = {@JoinColumn(referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
//    @ManyToMany // quiz table will have many to many relation with question table

    @ManyToMany
    @JoinTable(
            name = "quiz_questions",  // Name of the join table
            joinColumns = @JoinColumn(name = "quiz_id"),  // Name of the column in the join table that references Quiz
            inverseJoinColumns = @JoinColumn(name = "question_id")  // Name of the column in the join table that references Questions
    )
    private List<Questions> questions;


}
