package com.viniciusmdc.ExemploPatternPrototype.Books;


import com.viniciusmdc.ExemploPatternPrototype.Model.Book;
import com.viniciusmdc.ExemploPatternPrototype.Model.Dto.BookDto;
import com.viniciusmdc.ExemploPatternPrototype.Service.Impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BooksServiceTest {

    @InjectMocks
    private BookServiceImpl bookService;

    private ModelMapper modelMapper = new ModelMapper();

    private Book sampleBook = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 1925, "978-3-16-148410-0", 10.99, "Fiction", true);


    @Test
    public void shouldAddBook() {
        assertDoesNotThrow(() -> bookService.addBook(modelMapper.map(sampleBook, BookDto.class)));
    }

    @Test
    public void shouldFindBook() {
        Integer totalBookListSize = 10;
        List<Book> books = createBookList(totalBookListSize);

        for(Book book : books){
            bookService.addBook(modelMapper.map(book, BookDto.class));
        }

        Book b = assertDoesNotThrow(() -> bookService.findBookById(5));

        assertEquals(5, b.getId());
    }

    @Test
    public void shouldNotFindBook() {
        Integer totalBookListSize = 3;
        List<Book> books = createBookList(totalBookListSize);

        for(Book book : books){
            bookService.addBook(modelMapper.map(book, BookDto.class));
        }

        ResponseStatusException e = assertThrows(ResponseStatusException.class, () -> bookService.findBookById(5));

        assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
    }

    private List<Book> createBookList(Integer totalBooks){

        List<Book> books = new ArrayList<>();
        for(int i = 0; i < totalBooks; i++){
            Book b = sampleBook.clone();
            b.setId(i + 1);
            b.setTitle(String.format("%s %s", b.getTitle(), i + 1));
            books.add(b);
        }
        return books;
    }


}
