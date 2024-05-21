package com.thinkconstructor.restdemo.controller;

import com.thinkconstructor.restdemo.model.Student;
import com.thinkconstructor.restdemo.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
class StudentControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;
    private Student student;
    @BeforeEach
    void setup(){
         student = new Student(44, "xyz",99);
    }
    @Test
    public void testAddStudent() throws Exception{
        Student student = new Student(44, "xyz", 99);
        Mockito.when(studentService.addStudent(student)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/student").contentType(MediaType.APPLICATION_JSON).content("{\r\n" + "  \"id\": 44,\r\n" + "  \"name\":  \"xyz\",\r\n" + "  \"rollno\": 99" + "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
