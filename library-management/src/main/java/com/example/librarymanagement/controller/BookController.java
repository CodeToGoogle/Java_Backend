package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.BookResponse;
import com.example.librarymanagement.dto.CreateBookRequest;
import com.example.librarymanagement.dto.SearchBookRequest;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired //spring creates object in the IOC container and to use that we use this annotation
                //to fetch those objects/beans created also called as DI.
    BookService bookService;
    @PostMapping("") //Receives JSON object and converts them into java objects
    public Book createBook(@RequestBody @Valid CreateBookRequest createBookRequest){
        return bookService.create(createBookRequest);
    }

    @DeleteMapping("/{bookId}")
        public BookResponse deleteBook(@PathVariable("bookId") int bookId){
try {
    return BookResponse.from(bookService.delete(bookId));
}catch(Exception e){
    e.printStackTrace();
    throw e;
}
        }
        @GetMapping("/all")
        public List<Book> getAllBooks(){
        return bookService.get();
        }

        //pages<500
    //author_name, peter=
    //name 'Programming101'=
        @GetMapping("/{search}")
    public List<Book> getBookByAuthor(@RequestBody @Valid SearchBookRequest searchBookRequest) throws Exception {
        return bookService.search(searchBookRequest);

        }


}
