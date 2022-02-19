package com.spring.insta.insta.apiConfig;


import com.spring.insta.insta.apiRepository.ApiRepository;
import com.spring.insta.insta.dataClasses.UserData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApiConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(ApiRepository apiRepository){


        return args -> {
            UserData userData = new UserData("Ashu","Ashutosh","ashuemail","no bio","123456","no pic",2,3,4);


            apiRepository.saveAll(List.of(userData));


        };
    }
}
