package com.viniciusmdc.ExemploPatternPrototype.Service.Impl;

import com.viniciusmdc.ExemploPatternPrototype.Model.Book;
import com.viniciusmdc.ExemploPatternPrototype.Model.Dto.BookDto;
import com.viniciusmdc.ExemploPatternPrototype.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    //All methods are simplified because using the prototype pattern in testing is the main purpose of this code

    Integer currentBookSequence = 1;
    List<Book> books = new ArrayList<>();

    @Override
    public void addBook(BookDto bookDto) {
        Book book = bookDto.convertDtoToEntity();
        book.setId(currentBookSequence++);
        books.add(book);
    }

    @Override
    public Book findBookById(Integer id) {
        Optional<Book> b = books.stream().filter(book -> book.getId().equals(id)).findFirst();

        if(b.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found.");
        }

        return b.get();
    }

}
