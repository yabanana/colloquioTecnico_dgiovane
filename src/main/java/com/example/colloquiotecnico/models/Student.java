package com.example.colloquiotecnico.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Student {

    private long id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private List<String> grades;

    public Student() {}

    public Student(long id, String firstName, String lastName, String birthDate, List<String> grades) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.grades = grades;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }

    public int age() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate birthdate = LocalDate.parse(birthDate, formatter);
        LocalDate now = LocalDate.now();

        Period elapsed = Period.between(birthdate, now);

        return elapsed.getYears();
    }

    public int avg_grade() {
        int sum = 0;

        for(String grade : grades) {
            sum += Integer.parseInt(grade);
        }

        return sum / grades.size();
    }
}
