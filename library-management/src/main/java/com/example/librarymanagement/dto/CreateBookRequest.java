package com.example.librarymanagement.dto;

import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Genre;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {
    @NotBlank
    private String name; // book name

    @NotNull
    private Genre genre;

    private Integer pages;

    @NotBlank
    private String authorName;

    private String authorCountry;

    @NotBlank //checks for (Not null + empty String)
    private String authorEmail;

    public Book to(){
        return Book.builder()
                .name(this.name)
                .pages(this.pages)
                .genre(this.genre)
                .my_author(
                        Author.builder()
                                .name(this.authorName)
                                .country(this.authorCountry)
                                .email(this.authorEmail)
                                .build()
                )
                .build();
    }

}
