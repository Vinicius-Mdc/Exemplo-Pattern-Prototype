package com.viniciusmdc.ExemploPatternPrototype.Model.Dto;

import com.viniciusmdc.ExemploPatternPrototype.Model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private double price;
    private String genre;
    private boolean available;

    public Book convertDtoToEntity() {
        return new ModelMapper().map(this, Book.class);
    }

}
