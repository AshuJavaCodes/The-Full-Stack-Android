package com.example.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student maria = new Student("Ashutosh","2003","ashu@gmail.com",23);
            Student max = new Student("Singh","2005","ashuashu@gmail.com",35);
            //The way of saving all the Data to our database is as below :
            studentRepository.saveAll(List.of(maria,max));



        };
    }




}
