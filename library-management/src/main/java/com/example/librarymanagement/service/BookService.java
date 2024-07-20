package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.CreateBookRequest;
import com.example.librarymanagement.dto.SearchBookRequest;
import com.example.librarymanagement.model.*;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorService authorService;


    public Book create(CreateBookRequest createBookRequest) {

        Book book = createBookRequest.to();  // calling dto ---->>conversion to model
        Author author = authorService.createOrGet(book.getMy_author());// checking if author already exists or not if exists returning author from service class.

        //saving the author first as its primary key will be needed for book as foreign key only if we are providing the author details in that case.
        //we first saved author data so that its id gets generated and no error while mapping as author is parent.
        book.setMy_author(author); //primary key which is getting returned is being set here so that we don't get error of "unsaved transient instance"

        return bookRepository.save(book);
    }
    public void assignBookToStudent(Book book, Student student){
        bookRepository.assignBookToStudent(book.getId(),student);
    }
    public void unassignBookFromStudent(Book book){
        bookRepository.unassignBook(book.getId());
    }


    public Book delete(int bookId) {
    Book book=this.bookRepository.findById(bookId).orElse(null);
         List<Transaction> txnList=book.getTransactionList();
    bookRepository.deleteById(bookId);
         return book;
    }

    public List<Book> search(SearchBookRequest searchBookRequest) throws Exception {
//        boolean isValidRequest = searchBookRequest.validate();
//        if(!isValidRequest){
//            throw new Exception("Invalid Request");
//        }

//        String sql = "select b from Book b where b.searchKey searchOperator searchValue";

        switch (searchBookRequest.getSearchKey()){
            case "name":
                if(searchBookRequest.isAvailable()){
                    return bookRepository.findByNameAndmy_studentIsNull(searchBookRequest.getSearchValue());
                }
                return bookRepository.findByName(searchBookRequest.getSearchValue());
            case "genre":
                return bookRepository.findByGenre(Genre.valueOf(searchBookRequest.getSearchValue()));
            case "id": {
                Book book = bookRepository.findById(Integer.parseInt(searchBookRequest.getSearchValue())).orElse(null);
                return Arrays.asList(book);
            }

            default:
                throw new Exception("invalid search key");
        }


    }
    public List<Book> get(){
        return bookRepository.findAll();
    }

    // 1. An error will occur because of wrong foreign key mapping (author id == null)
    // 2. An error will occur but not because of null author id --  correct (Hibernate)
    // 3. book will be created but no author will be created
    // 4. both book and author will be created and mapped also accordingly


}
