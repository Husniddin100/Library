package com.example.librarys.Controller;

import com.example.librarys.Entity.Student;
import com.example.librarys.Exception.AppBadException;
import com.example.librarys.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> all() {
        return ResponseEntity.ok(studentService.all());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        Student student = studentService.get(id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody Student student,
                                    @PathVariable("id") String id) {
        return ResponseEntity.ok(studentService.update(id, student));
    }
}
