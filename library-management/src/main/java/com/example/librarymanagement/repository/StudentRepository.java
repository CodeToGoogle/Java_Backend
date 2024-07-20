package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.name = :name, s.contact = :contact WHERE s.id = :id")
    void updateStudent(@Param("id") int id, @Param("name") String name, @Param("contact") String contact);

}
