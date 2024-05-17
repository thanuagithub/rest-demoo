package com.thinkconstructor.restdemo.controller;
import com.thinkconstructor.restdemo.model.Student;
import com.thinkconstructor.restdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentdatabase")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/store")
    public Student saveStudent(@RequestBody Student student){
        return studentService.create(student);
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
}