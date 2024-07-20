package com.example.librarymanagement.dto;

import com.example.librarymanagement.model.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateStudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String contact;

    private Date validity;

    public Student to() {
        return Student.builder()
                .name(this.name)
                .contact(this.contact)
                .validity(this.validity)
                .build();

    }
}
