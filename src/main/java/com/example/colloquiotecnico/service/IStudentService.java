package com.example.colloquiotecnico.service;

import com.example.colloquiotecnico.models.Student;

import java.util.Optional;

public interface IStudentService {

    public Iterable<Student> getAll();

    public Optional<Student> getById(int id);

    public Student create(Student student);
}
