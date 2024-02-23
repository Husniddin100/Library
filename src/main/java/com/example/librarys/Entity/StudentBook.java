package com.example.librarys.Entity;

import com.example.librarys.Entity.Book;
import com.example.librarys.Entity.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "StudentBook")
public class StudentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student_id;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book_id;
    @Column(name = "created_date")
    private LocalDate createdDate;

}
