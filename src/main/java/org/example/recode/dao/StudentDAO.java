package org.example.recode.dao;

import org.example.recode.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();
    public Student getById(int id);
    public Student saveStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(int id);

}
