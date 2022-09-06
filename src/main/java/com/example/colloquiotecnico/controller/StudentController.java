package com.example.colloquiotecnico.controller;

import com.example.colloquiotecnico.models.Student;
import com.example.colloquiotecnico.service.IStudentService;
import com.example.colloquiotecnico.service.ListStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    @Qualifier("mainStudentService")
    private IStudentService studentService;

    @GetMapping("api/students")
    public Iterable<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("api/students/{id}")
    public Student getById(@PathVariable int id) {

        Optional<Student> student = studentService.getById(id);

        if(student.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found");
        }

        return student.get();
    }

    @PostMapping("api/students")
    public Student create(@RequestBody Student student) {
        studentService.create(student);

        return student;
    }
}
