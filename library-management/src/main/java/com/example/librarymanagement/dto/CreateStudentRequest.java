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
public class CreateStudentRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String contact;

    public Student to(){
        return Student.builder()
                .name(this.name)
                .contact(this.contact)
                .validity(new Date(System.currentTimeMillis() + 31536000000L)) // 1 year from now
                .build();
    }

}
