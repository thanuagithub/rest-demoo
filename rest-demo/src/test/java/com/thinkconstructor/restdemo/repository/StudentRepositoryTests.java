package com.thinkconstructor.restdemo.repository;

import com.thinkconstructor.restdemo.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setup(){
        Student student = new Student(44, "xyz", 99);
        entityManager.persist(student);
    }
    @Test
    public void testFindById(){
        Student student = studentRepository.findById(44).get();
        assertEquals("xyz", student.getName());
    }
}
