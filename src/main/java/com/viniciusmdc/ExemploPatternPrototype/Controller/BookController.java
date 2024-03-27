package com.viniciusmdc.ExemploPatternPrototype.Controller;

import com.viniciusmdc.ExemploPatternPrototype.Model.Book;
import com.viniciusmdc.ExemploPatternPrototype.Model.Dto.BookDto;
import com.viniciusmdc.ExemploPatternPrototype.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    @RequestMapping("/{id}")
    ResponseEntity<Book> findBookById(@PathVariable Integer id){

        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.OK);

    }

    @PostMapping
    ResponseEntity<String> createBook(@RequestBody BookDto book){
        bookService.addBook(book);
        return new ResponseEntity<>("Book created successfully!", HttpStatus.OK);
    }

}
