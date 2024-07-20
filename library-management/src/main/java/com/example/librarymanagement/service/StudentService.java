package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.CreateStudentRequest;
import com.example.librarymanagement.dto.UpdateStudentRequest;
import com.example.librarymanagement.model.Student;
import com.example.librarymanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student create(CreateStudentRequest createStudentRequest) {
    Student student=createStudentRequest.to();
    return studentRepository.save(student);
    }

    public Student get(int studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public Student delete(int studentId) {
        Student student=this.get(studentId);
        studentRepository.deleteById(studentId);
        return student;
    }

    public Student update(int studentId, UpdateStudentRequest updateStudentRequest) {
        studentRepository.updateStudent(studentId, updateStudentRequest.getName(), updateStudentRequest.getContact());

        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Updated student not found with id: " + studentId));


    }
}
