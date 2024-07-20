package com.example.librarymanagement.dto;

import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Genre;
import com.example.librarymanagement.model.Student;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private int id;
    private String name;
    private Genre genre;
    private Integer pages;
    private Author my_author; // M:1 from Book : Author

    private Student my_student; // M:1 from Book: Student

    private Date createdOn;
    private Date updatedOn;

    public static BookResponse from(Book b){
        return BookResponse.builder()
                .id(b.getId())
                .genre(b.getGenre())
                .createdOn(b.getCreatedOn())
                .updatedOn(b.getUpdatedOn())
                .pages(b.getPages())
                .my_author(b.getMy_author())
                .my_student(b.getMy_student())
                .name(b.getName())
                .build();
    }

}