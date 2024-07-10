package com.spring.rest.api.springRestapiDemo.controller;

import com.spring.rest.api.springRestapiDemo.model.Book;
import com.spring.rest.api.springRestapiDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

        @GetMapping("/bookall")
        public ResponseEntity<List<Book>> getBookData()
        {
            List<Book> bookdata= bookService.getAll();
            if(bookdata.size()<=0)
            {
                return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            }
            else
            {
                return  ResponseEntity.of(Optional.of(bookdata));
            }
        }
        @GetMapping("/book/{id}")
        public Book getSingleBook(@PathVariable("id") int id)
        {
            return bookService.getSingleById(id);
        }
}
