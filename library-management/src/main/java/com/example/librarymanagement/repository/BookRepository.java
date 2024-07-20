package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Genre;
import com.example.librarymanagement.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("select b from Book b where b.name =:name and b.my_student is null")
    List<Book> findByNameAndmy_studentIsNull(String name); //find books that are not associated with any students.

    List<Book> findByName(String name);

    List<Book> findByGenre(Genre genre);

    @Modifying // for DML support
    @Transactional // for updating any data
    @Query("update Book b set b.my_student = ?2 where b.id = ?1 and b.my_student is null")
    void assignBookToStudent(int bookId, Student student);

    @Modifying // for DML support
    @Transactional // for updating any data
    @Query("update Book b set b.my_student = null where b.id = ?1 ")
    void unassignBook(int bookId);
}
