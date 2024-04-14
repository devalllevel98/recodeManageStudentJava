package org.example.recode.rest;

import org.example.recode.entity.Student;
import org.example.recode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudent(){
        return this.studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getByIdStudent(@PathVariable int id){
        Optional<Student> st = this.studentService.getById(id);
        if(st.isPresent()){
            return ResponseEntity.ok(st.get());
        }else{
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        student.setId(0);
        student = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
        Optional<Student> exitStudent = studentService.getById(id);
        if(exitStudent.isPresent()){
           Student Student = exitStudent.get();
            Student.setFirstName(student.getFirstName());
            Student.setLastName(student.getLastName());
            Student.setEmail(student.getEmail());
            studentService.updateStudent(Student);
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        Optional<Student> exitStudent = studentService.getById(id);
        if(exitStudent.isPresent()){
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/not/{firstname}")
    public List<Student> getFirstNameNot(@PathVariable String firstname){
        return studentService.findByFirtNameNot(firstname);
    }




}
