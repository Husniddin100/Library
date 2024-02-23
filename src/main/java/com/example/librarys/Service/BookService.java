package com.example.librarys.Service;

import com.example.librarys.Entity.Book;
import com.example.librarys.Exception.AppBadException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Book")
public class BookService {
    private List<Book> bookList=new LinkedList<>();
    public Boolean create(){
        Book book=new Book();
        if (book.getTitle() == null || book.getTitle().trim().length() < 3) {
            throw new AppBadException("wrong title required");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().length() < 3) {
            throw new AppBadException("wrong author name required");
        }
        book.setId(1);
        book.setAuthor("Ali");
        book.setTitle("Harry potter");
        book.setPublishYear(LocalDate.parse("12-02-2002"));
        bookList.add(book);
        System.out.println(bookList);
        return true;
    }
    public List<Book> all() {
        return bookList;
    }
    public Book get(String id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        throw new AppBadException("Student not found");
    }
    public Boolean delete(String id){
        return bookList.removeIf(book -> book.getId().equals(id));
    }
    public Book update(String id, Book books) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                book.setTitle(books.getTitle());
                book.setAuthor(books.getAuthor());
                book.setPublishYear(books.getPublishYear());
                return book;
            }
        }
        throw new AppBadException("Student not found");
    }


}
