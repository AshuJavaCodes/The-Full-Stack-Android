package com.example.demo.StudentService;

import com.example.demo.Student;
import com.example.demo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//This will Tell the AutoWired to Use this componet for the service class.
@Component
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {

        return studentRepository.findAll();
    }
    //Detecting if the Email Exits or Not form the Buiness Logic.

    public void addNewStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException();
        }else {
            studentRepository.save(student);
        }



    }




}
