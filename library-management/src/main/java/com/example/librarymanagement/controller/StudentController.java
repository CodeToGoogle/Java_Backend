package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.CreateStudentRequest;
import com.example.librarymanagement.dto.UpdateStudentRequest;
import com.example.librarymanagement.model.Student;
import com.example.librarymanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("")
    public Student createStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        return studentService.create(createStudentRequest);
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {
        return studentService.get(studentId);
    }

    @DeleteMapping("")
    public Student deleteStudent(@RequestParam("id") int studentId) {
        return studentService.delete(studentId);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody @Valid UpdateStudentRequest updateStudentRequest) {
        return studentService.update(studentId, updateStudentRequest);

    }
}
