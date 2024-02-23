package com.example.librarys.Controller;

import com.example.librarys.Entity.Book;
import com.example.librarys.Exception.AppBadException;
import com.example.librarys.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("create/")
    public ResponseEntity<?> create(@RequestBody Book book) {
        bookService.create();
        return ResponseEntity.ok(true);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> all() {
        return ResponseEntity.ok(bookService.all());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        Book book = bookService.get(id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(bookService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody Book books,
                                    @PathVariable("id") String id) {
        return ResponseEntity.ok(bookService.update(id, books));

    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<?> handle(AppBadException appBadException) {
        return ResponseEntity.badRequest().body(appBadException.getMessage());
    }

}
