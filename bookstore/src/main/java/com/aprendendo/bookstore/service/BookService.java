package com.aprendendo.bookstore.service;

import com.aprendendo.bookstore.dto.MessageResponseDTO;
import com.aprendendo.bookstore.entities.Book;
import com.aprendendo.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(Book book){
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID: " + savedBook.getId())
                .build();
    }
}
