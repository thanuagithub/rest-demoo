package com.thinkconstructor.restdemo.service;

import com.thinkconstructor.restdemo.model.Student;
import com.thinkconstructor.restdemo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class StudentServiceTests {
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setup() {
        Optional<Student> student = Optional.of(new Student(1, "abc", 100));
        Mockito.when(studentRepository.findById(1)).thenReturn(student);
    }

    @Test
    public void testgetStudentById_Success(){
        String student_name = "abc";
        studentService.getStudentById(1);
        Class<Object> studentById = null;
        assertEquals(student_name, studentById.getName());
    }

}
