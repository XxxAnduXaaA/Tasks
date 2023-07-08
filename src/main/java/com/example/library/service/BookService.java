package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Genre;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private  AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;


public Book createBook(Book book, Author author, Genre genre) {


    Author existingAuthor = authorRepository.findByFirstNameAndMiddleNameAndLastNameAndBirthDate(
            author.getFirstName(), author.getMiddleName(), author.getLastName(), author.getBirthDate());

    if (existingAuthor == null) {
        authorRepository.save(author);
    } else {
        book.setAuthor(existingAuthor);
    }

    Genre existingGenre = genreRepository.findByDescription(genre.getDescription());

    if (existingGenre == null) {
        genreRepository.save(genre);
    } else {
        book.setGenre(existingGenre);
    }

    book.setCreatedAt(new Date());
    book.setModifiedAt(new Date());

    return bookRepository.save(book);
}


    public Book updateBook(Long id, Book updatedBook){
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (existingBook != null) {
            existingBook.setIsbn(updatedBook.getIsbn());

            existingBook.setModifiedAt(new Date());

            return bookRepository.save(existingBook);
        }

        else {
            return null;
        }
    }

    public void deleteBook(Long id){
        bookRepository.deleteBookById(id);
    }

    public Book getBook(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

}
