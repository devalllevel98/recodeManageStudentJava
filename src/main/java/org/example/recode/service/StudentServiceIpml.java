package org.example.recode.service;

import org.example.recode.dao.StudentRepositiry;
import org.example.recode.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceIpml implements StudentService{
    private StudentRepositiry studentRepositiry;
    @Autowired
    public StudentServiceIpml(StudentRepositiry studentRepositiry) {
        this.studentRepositiry = studentRepositiry;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepositiry.findAll();
    }

    @Override
    public Optional<Student> getById(int id) {
        return studentRepositiry.findById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepositiry.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepositiry.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepositiry.deleteById(id);
    }

    @Override
    public List<Student> findByFirtNameNot(String firtsName) {
        return studentRepositiry.findByFirstNameNot(firtsName);
    }
}
