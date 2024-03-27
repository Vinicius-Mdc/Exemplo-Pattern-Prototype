package com.viniciusmdc.ExemploPatternPrototype.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private double price;
    private String genre;
    private boolean available;

    public Book clone(){
        return new ModelMapper().map(this, Book.class);
    }
}
