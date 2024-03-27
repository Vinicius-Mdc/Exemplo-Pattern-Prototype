package com.viniciusmdc.ExemploPatternPrototype.Service;

import com.viniciusmdc.ExemploPatternPrototype.Model.Book;
import com.viniciusmdc.ExemploPatternPrototype.Model.Dto.BookDto;

public interface BookService {

    void addBook(BookDto book);

    Book findBookById(Integer id);

}
