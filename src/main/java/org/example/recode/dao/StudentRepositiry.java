package org.example.recode.dao;

import org.example.recode.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "students")
public interface StudentRepositiry extends JpaRepository<Student, Integer> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameAndLastName(String firstName, String last_name);

    //query student firstname khacs voi gia tri tim kiem
//    public List<Student> findByFirstNameNot(String firstName);

    @Query("SELECT s FROM Student s WHERE s.firstName like ?1")
    public List<Student> findByFirstNameNot(String firstName);



}
