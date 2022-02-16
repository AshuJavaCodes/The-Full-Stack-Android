package com.example.demo.StudentController;



import com.example.demo.Student;
import com.example.demo.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testapi/student")
public class StudentController {

    private StudentService studentService;


    //This Annotatio will Tell Spring boot to use the above variable to instantiate the below method
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudent")
    public List<Student> getStudent(){
        return  studentService.getStudent();

    }
    //Designing a Post Request in Spring Boot.
    @PostMapping("/studentSignup")
    public void saveStudent(@RequestBody Student student){
        //Logic of the Service Layer will Go here.
        studentService.addNewStudent(student);




    }



}
