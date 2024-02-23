package com.example.librarys.Service;

import com.example.librarys.Entity.Student;
import com.example.librarys.Exception.AppBadException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {
    private List<Student>studentList=new LinkedList<>();
    public List<Student> all(){
        return studentList;
    }
  public Student get(String id){
        for (Student student:studentList){
            if (student.getId().equals(id)){
              return student;
            }
        }
      throw new AppBadException("student not found");
  }
    public Boolean delete(String id){
        return studentList.removeIf(dto -> dto.getId().equals(id));
    }

    public Student update(String id, Student student) {
        if (student.getName() == null || student.getName().trim().length() < 3) {
            throw new AppBadException("Student name required");
        }
        if (student.getSurname() == null || student.getSurname().trim().length() < 3) {
            throw new AppBadException("Student Surname required");
        }
        for (Student student1 : studentList) {
            if (student1.getId().equals(id)) {
                student1.setName(student.getName());
                student1.setSurname(student.getSurname());
                student1.setPhone(student.getPhone());
                student1.setCreatedDate(student.getCreatedDate());
                return student1;
            }
        }
        throw new AppBadException("Student not found");
    }
}
