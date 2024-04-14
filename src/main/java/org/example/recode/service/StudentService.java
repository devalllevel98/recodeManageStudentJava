package org.example.recode.service;

import org.example.recode.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getAllStudent();
    public Optional<Student> getById(int id);
    public Student saveStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(int id);
    public List<Student> findByFirtNameNot(String firtsName);
}
