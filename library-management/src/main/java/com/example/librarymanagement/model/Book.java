package com.example.librarymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

//one author can write multiple books 1:M relationship

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(value =EnumType.STRING ) //what type of value you are expecting in enum
    private Genre genre;

    private Integer pages;
    //one author can write multiple books
    // 1        :       M
    //Author            Books

    //first part =entity in which you are writing this annotation(Many)
    //second part= entity on top of which you are writing this annotation(one)
    @ManyToOne //Many books can be written by one author
    @JoinColumn //primary key of author table will act as a foreign key in book table
    @JsonIgnoreProperties({"bookList"})
    private Author my_author;

    @ManyToOne //
    @JoinColumn //primary key of student table will act as a foreign key in book table
    @JsonIgnoreProperties({"bookList"})
    private Student my_student;  //M:1 from Book : Student

    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)//doesn't automatically fetch any associated entities
    @JsonIgnoreProperties({"book"})
    List<Transaction> transactionList;
}
