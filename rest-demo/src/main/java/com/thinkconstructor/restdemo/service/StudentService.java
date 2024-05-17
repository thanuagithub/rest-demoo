package com.thinkconstructor.restdemo.service;

import com.thinkconstructor.restdemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface StudentService {
    public Student create(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(Integer id);

    public Student update(Student student);

    public String deleteStudent(Integer id);
}
