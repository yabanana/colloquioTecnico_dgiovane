package com.example.colloquiotecnico.service;

import com.example.colloquiotecnico.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("mainStudentService")
public class ListStudentService implements IStudentService{

    private List<Student> repo;
    private long lastId;

    public ListStudentService() {

        repo = new ArrayList<Student>();

        List<String> grades = new ArrayList<>();
        grades.add("uno");
        grades.add("due");

        Student s = new Student();
        s.setId(1);
        s.setBirthDate("aaaa");
        s.setGrades(grades);
        s.setFirstName("Daniele");
        s.setLastName("Giovane");
        s.setBirthDate("trenta");

        repo.add(s);
    }

    @Override
    public Iterable<Student> getAll() {
        return repo;
    }

    @Override
    public Optional<Student> getById(int id) {

        Optional<Student> student = repo.stream()
                .filter(elem ->elem.getId() == id)
                .findFirst();

        return Optional.empty();
    }

    @Override
    public Student create(Student student) {
        student.setId(lastId++);
        repo.add(student);
        return student;
    }
}
